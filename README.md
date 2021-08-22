# Event-driven Microservices Workshop

Event-Driven Microservices Workshops with hands-on tutorials for working with Kafka, Java, Spring Boot, KafkaStreams and ksqlDB ...

This workshop is part of the Trivadis course [Event-Driven Microservices](https://www.trivadis.com/en/training/event-driven-microservices) as well as the [Event-Driven Architecture of the Microservices Integration and Operations CAS](https://www.bfh.ch/de/weiterbildung/cas/microservices-integration-and-operations/) at the Berner Fachhochschule.

All the workshops can be done on a container-based infrastructure using Docker Compose for the container orchestration. It can be run on a local machine or in a cloud environment. Check [01-environment](https://github.com/gschmutz/hadoop-workshop/tree/master/01-environment) for instructions on how to setup the infrastructure.


## List of Workshops

ID  | Title   | Descritpion
------------- | ------------- | -------------
2 | [Getting started with Apache Kafka](./02-working-with-kafka-broker) | Create topics from the command line, use the Console Producer and Console Consumer to publish and consume messages and show how to use `kafakcat`.
3 | [Testing Consumer Scalability and Kafka Failover](./03-understanding-failover)  | demonstrates consumer failover and broker failover and load balancing over various consumers within a consumer group
4 | [Using Kafka from Java](./04-producing-consuming-kafka-with-java)  | learn how to produce and consume simple messages using the Kafka Java API. Secondly we will see how to produce/consume complex objects using JSON serialization.
4a | [Using Kafka from Java with Avro & Schema Registry](./04a-working-with-avro-and-java)  | learn how to produce and consume messages using the Kafka Java API using Avro for serialization with the Confluent Schema Registry.
4b | [Working with CloudEvents and Java](./04b-working-with-cloudenvent-and-java)  | learn how to produce  messages using the Kafka Java API with CloudEvents.
5 | [Using Kafka from Spring Boot](./05-producing-consuming-kafka-with-springboot)  | learn how to use Spring Boot to consume and produce from/to Kafka
5a | [Using Kafka from Spring Boot with Avro & Schema Registry](./05a-working-with-avro-and-springboot)  | learn how to use Spring Boot to consume and produce from/to Kafka using Avro for serialization with the Confluent Schema Registry.
6 |[Using Kafka with Confluent's Python client](./06-producing-consuming-kafka-with-python)  | learn how to use Python to consume and produce from/to Kafka
7 | [Using Kafka with Confluent's .NET client](./07-producing-consuming-kafka-with-dotnet)  | learn how to use .NET to consume and produce from/to Kafka
8 | [Using Kafka Streams](./07-using-kafka-streams-simple)  | learn how to use Kafka Streams from Java to perform stream analytics
8a | [Using Kafka Streams from Spring Boot](./07a-using-kafka-streams-from-springboot)  | learn how to use Kafka Streams from Spring Boot to extend your Spring Boot microservice with stream analytics capabilities