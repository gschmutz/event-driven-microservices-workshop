package com.trivadis.kafkaws.springbootkafkaproducer;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.interceptor.CacheOperationInvocationContext;

import java.time.LocalDateTime;

@SpringBootApplication
public class SpringBootKafkaProducerApplication implements CommandLineRunner {

	private static Logger LOG = LoggerFactory.getLogger(SpringBootKafkaProducerApplication.class);

	@Autowired
	private KafkaEventProducer kafkaEventProducer;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootKafkaProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("EXECUTING : command line runner");

		if (args.length == 0) {
			runProducer(100, 10, 0);
		} else {
			runProducer(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Long.parseLong(args[2]));
		}

	}

	private void runProducer(int sendMessageCount, int waitMsInBetween, long id) throws Exception {
		Long key = (id > 0) ? id : null;

		for (int index = 0; index < sendMessageCount; index++) {
			long time = System.currentTimeMillis();
			String value =  "[" + id + "] Hello Kafka " + index + " => " + LocalDateTime.now();

			RecordMetadata metadata = kafkaEventProducer.produce(key, value);

			long elapsedTime = System.currentTimeMillis() - time;
			System.out.printf("[" + id + "] sent record(key=%s value=%s) "
							+ "meta(partition=%d, offset=%d) time=%d\n",
					key, value, metadata.partition(),
					metadata.offset(), elapsedTime);

			// Simulate slow processing
			Thread.sleep(waitMsInBetween);

		}
	}

}
