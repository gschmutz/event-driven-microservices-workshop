# Using Kafka Streams

In this workshop we will learn how to process messages using the [KafkaStreams](https://kafka.apache.org/documentation/streams/) library.

We will create a basic processor which consumes messages from a topic, processes them and produces the result into a new topic. We will be using once the DSL and once the more low-level Processor API.

## Create the project in your Java IDE

In your favorite IDE, create a new Maven project and use `com.trivadis.kafkaws` for the **Group Id** and `kafka-streams-simple` for the **Artifact Id**.

Navigate to the **pom.xml** and double-click on it. The POM Editor will be displayed. 

Let's add some initial dependencies for our project. We will add some more dependencies to the POM throughout this workshop.

First add the following property into the already existing `<properites>` section


```xml
   <properties>
       ...
       <kafka.version>2.8.0</kafka.version>
       <slf4j.version>1.7.32</slf4j.version>
    </properties>
```

Copy the following block right after the `<properties>` tag, before the closing `</project>` tag.
    
```xml
    <dependencies>
        <dependency>
            <groupId>org.apache.kafka</groupId>
            <artifactId>kafka-streams</artifactId>
            <version>${kafka.version}</version>
        </dependency>
        
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-log4j12</artifactId>
            <version>${slf4j.version}</version>
        </dependency>        
    </dependencies>
    
	<build>
		<defaultGoal>install</defaultGoal>

		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>2.5</version>
				<configuration>
					<source>15</source>
					<target>15</target>
					<maxmem>256M</maxmem>
					<showDeprecation>true</showDeprecation>
				</configuration>
			</plugin>
			<plugin>
				<groupId>org.codehaus.mojo</groupId>
				<artifactId>exec-maven-plugin</artifactId>
				<version>3.0.0</version>
				<executions>
					<execution>
						<id>producer</id>
						<goals>
							<goal>java</goal>
						</goals>
						<configuration>
							<mainClass>com.trivadis.kafkaws.processor.KafkaStreamsRunner</mainClass>
						</configuration>						
					</execution>
				</executions>
			</plugin>
		</plugins>
	</build>
```

## Create a log4j.properties file

In the `resources` folder, create a `log4j.properties` file and add the following content:

```properties
log4j.rootLogger=WARN, stdout

log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=[%d] %p [%t] %m (%c)%n

# Enable for debugging if need be
#log4j.logger.org.apache.kafka.streams=DEBUG, stdout
#log4j.additivity.org.apache.kafka.streams=false

# Squelch expected error messages like:
#     java.lang.IllegalStateException: This consumer has already been closed.
log4j.logger.org.apache.kafka.streams.processor.internals.StreamThread=WARN, stdout
log4j.additivity.org.apache.kafka.streams.processor.internals.StreamThread=false

#Enable info for Microservices
log4j.logger.io.confluent.examples.streams.microservices=INFO, stdout
log4j.additivity.io.confluent.examples.streams.microservices=false

# Enable for debugging if need be
#log4j.logger.io.confluent=DEBUG, stdout
#log4j.additivity.io.confluent=false
```

## Creating the necessary Kafka Topic 

We will use the topic `test-kstream-input-topic` and `test-kstream-output-topic` in the KafkaStream processorcode below. Due to the fact that `auto.topic.create.enable` is set to `false`, we have to manually create the topic. 

Connect to the `kafka-1` container and execute the necessary kafka-topics command. 

```bash
docker exec -ti kafka-1 kafka-topics --create \
    --replication-factor 3 \
    --partitions 8 \
    --topic test-kstream-input-topic \
    --zookeeper zookeeper-1:2181
    
docker exec -ti kafka-1 kafka-topics --create \
    --replication-factor 3 \
    --partitions 8 \
    --topic test-kstream-output-topic \
    --zookeeper zookeeper-1:2181
```

This finishes the setup steps and our new project is ready to be used. Next we will implement the KafkaStreams Processor Topology, first using the DSL and second using the Processor API.

## Implementing the Kafka Streams Processor using the DSL

Create a new Java package `com.trivads.kafkaws.kstream` and in it a Java class `KafkaStreamsRunnerDSL`. 

Add the following code for the implemenation

```java
package com.trivads.kafkaws.kstream;

import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Printed;

class KafkaStreamsRunnerDSL {

    public static void main(String[] args) {
        // the builder is used to construct the topology
        StreamsBuilder builder = new StreamsBuilder();

        // read from the source topic, "users"
        KStream<Void, String> stream = builder.stream("test-kstream-input-topic");

        // for each record that appears in the source topic,
        // print the value
        stream.foreach(
                (key, value) -> {
                    System.out.println("(From DSL) " + value);
                });

        // transform the values to upper case
        KStream<Void, String> upperStream = stream.mapValues(value -> value.toUpperCase());

        // you can also print using the `print` operator
        upperStream.print(Printed.<Void, String>toSysOut().withLabel("upperValue"));

        upperStream.to("test-kstream-output-topic");

        // set the required properties for running Kafka Streams
        Properties config = new Properties();
        config.put(StreamsConfig.APPLICATION_ID_CONFIG, "dev1");
        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "dataplatform:9092");
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.Void().getClass());
        config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        // build the topology and start streaming
        KafkaStreams streams = new KafkaStreams(builder.build(), config);
        streams.start();

        // close Kafka Streams when the JVM shuts down (e.g. SIGTERM)
        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
    }
}
```

Start the programm and then first run a `kafkacat` consumer on the output topic

```bash
kafkacat -b dataplatform:9092 -t test-kstream-output-topic
```

with that in place, in 2nd terminal produce some messages using `kafkacat` in producer mode on the input topic

```bash
kafkacat -b dataplatform:9092 -t test-kstream-input-topic -P
```

All the values produced should arrive on the consumer in uppercase.

## Aggregating Values 

Now let's use Kafka Streams to perform some stateful operations. We will group the messages by key and count the number of messages per key over 60 seconds.

Create a new Java package `com.trivads.kafkaws.kstream.aggregation` and in it a Java class `KafkaStreamsRunnerDSL`. 

Add the following code for the implemenation

```java
package com.trivads.kafkaws.kstream.aggregation;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.*;

import java.time.Duration;
import java.util.Properties;

import static org.apache.kafka.streams.kstream.Suppressed.BufferConfig.unbounded;

class KafkaStreamsRunnerDSL {

    public static void main(String[] args) {
        // the builder is used to construct the topology
        StreamsBuilder builder = new StreamsBuilder();

        // read from the source topic, "test-kstream-input-topic"
        KStream<String, String> stream = builder.stream("test-kstream-input-topic");

        // create a tumbling window of 60 seconds
        TimeWindows tumblingWindow =
                TimeWindows.of(Duration.ofSeconds(60));

        KTable<Windowed<String>, Long> counts = stream.groupByKey()
                .windowedBy(tumblingWindow)
                .count(Materialized.as("count"));

        counts.toStream().print(Printed.<Windowed<String>, Long>toSysOut().withLabel("counts"));

        final Serde<String> stringSerde = Serdes.String();
        final Serde<Long> longSerde = Serdes.Long();
        counts.toStream().map((k,v) -> new KeyValue<>(k.toString(), v)).to("test-kstream-output-topic", Produced.with(stringSerde, longSerde));
        
        // set the required properties for running Kafka Streams
        Properties config = new Properties();
        config.put(StreamsConfig.APPLICATION_ID_CONFIG, "dev1");
        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "dataplatform:9092");
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        // build the topology and start streaming
        KafkaStreams streams = new KafkaStreams(builder.build(), config);
        streams.start();

        // close Kafka Streams when the JVM shuts down (e.g. SIGTERM)
        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
    }
}
```

Start the programm and then first run a `kafkacat` consumer on the output topic

```bash
kafkacat -b dataplatform:9092 -t test-kstream-output-topic -s value=q -o end -f "%k,%s\n"
```

with that in place, in 2nd terminal produce some messages using `kafkacat` in producer mode on the input topic

```bash
kafkacat -b dataplatform:9092 -t test-kstream-input-topic -P -K , 
```

produce some values with `<key>,<value>` syntax, such as

```bash
A,AAA
A,AAA
B,BBB
B,BBB
C,CCC
D,DDD
E,EEE
D,DDD
```

within a single minute. After a minute the output from the consumer should be similar to the one shown below

```bash
[A@1629062820000/1629062880000],3
[D@1629062820000/1629062880000],2
[B@1629062820000/1629062880000],3
[E@1629062820000/1629062880000],1
```

## Using Custom State 

Create a new Java package `com.trivads.kafkaws.kstream.customstate` and in it a Java class `KafkaStreamsRunnerDSL`. 

Add the following code for the implemenation

```java
package com.trivads.kafkaws.kstream.customstate;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Transformer;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.KeyValueStore;
import org.apache.kafka.streams.state.StoreBuilder;
import org.apache.kafka.streams.state.Stores;

import java.util.Properties;

class KafkaStreamsRunnerDSL {

    public static void main(String[] args) {
        // the builder is used to construct the topology
        StreamsBuilder builder = new StreamsBuilder();

        final StoreBuilder<KeyValueStore<String, String>> myStateStore = Stores
                .keyValueStoreBuilder(Stores.persistentKeyValueStore("MyStateStore"), Serdes.String(), Serdes.String())
                .withCachingEnabled();
        builder.addStateStore(myStateStore);

        final MyStateHandler myStateHandler = new MyStateHandler(myStateStore.name());

        // read from the source topic, "test-kstream-input-topic"
        KStream<String, String> stream = builder.stream("test-kstream-input-topic");

        KStream<String, String> transformedStream = stream.transform(() -> myStateHandler, myStateStore.name() );

        transformedStream.peek((k,v) -> System.out.println("key: " + k + " - value:" + v));

        // set the required properties for running Kafka Streams
        Properties config = new Properties();
        config.put(StreamsConfig.APPLICATION_ID_CONFIG, "dev1");
        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "dataplatform:9092");
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        // build the topology and start streaming
        KafkaStreams streams = new KafkaStreams(builder.build(), config);
        streams.start();

        // close Kafka Streams when the JVM shuts down (e.g. SIGTERM)
        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
    }

    private static final class MyStateHandler implements Transformer<String, String, KeyValue<String, String>> {
        final private String storeName;
        private KeyValueStore<String, String> stateStore;
        private ProcessorContext context;

        public MyStateHandler(final String storeName) {
            this.storeName = storeName;
        }


        @Override
        public void init(ProcessorContext processorContext) {
            this.context = processorContext;
            stateStore = (KeyValueStore<String, String>) this.context.getStateStore(storeName);
        }

        @Override
        public KeyValue<String,String> transform(String key, String value) {
            if (stateStore.get(key) == null) {
                stateStore.put(key, value);
            } else {
                stateStore.put(key, stateStore.get(key) + "," + value);
            }

            return new KeyValue<>(key, stateStore.get(key));
        }

        @Override
        public void close() {

        }
    }
}
```


## Implementing the Kafka Streams Processor using the Processor API

Create a new Java package `com.trivads.kafkaws.kstream` and in it a Java class `KafkaStreamsRunnerDSL`. 

Add the following code for the implemenation

```java
package com.trivads.kafkaws.kstream;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;

import java.util.Properties;

public class KafkaStreamsRunnerProcessorAPI {
    public static void main(String[] args) {
        // the builder is used to construct the topology
        Topology topology = new Topology();

        topology.addSource("TestSource", "test-kstream-input-topic");
        topology.addProcessor("ToUpperCaseProcessor", () -> new ChangeCaseProcessor(true), "TestSource");
        topology.addSink("TestSink", "test-kstream-output-topic", "ToUpperCaseProcessor");

        // set the required properties for running Kafka Streams
        Properties config = new Properties();
        config.put(StreamsConfig.APPLICATION_ID_CONFIG, "dev2");
        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "dataplatform:9092");
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.Void().getClass());
        config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        // build the topology and start streaming!
        KafkaStreams streams = new KafkaStreams(topology, config);
        System.out.println("Starting streams");
        streams.start();

        // close Kafka Streams when the JVM shuts down (e.g. SIGTERM)
        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
    }
}
```

```java
package com.trivads.kafkaws.kstream;

import org.apache.kafka.streams.processor.api.Processor;
import org.apache.kafka.streams.processor.api.ProcessorContext;
import org.apache.kafka.streams.processor.api.Record;

public class ChangeCaseProcessor implements Processor<Void, String, Void, String> {
    private ProcessorContext<Void,String> context = null;
    private boolean toUpperCase = true;

    public ChangeCaseProcessor(boolean toUpperCase) {
        this.toUpperCase = toUpperCase;
    }

    @Override
    public void init(ProcessorContext<Void, String> context) {
        this.context = context;
    }

    @Override
    public void process(Record<Void, String> record) {
        System.out.println("(Processor API) " + record.value());
        String newValue = record.value();

        if (toUpperCase) {
            newValue = record.value().toUpperCase();
        } else {
            newValue = record.value().toLowerCase();
        }
        Record<Void, String> newRecord = new Record<>(record.key(), newValue, record.timestamp());
        context.forward(newRecord);
    }

    @Override
    public void close() {
        // no special clean up needed in this example
    }
}
```
