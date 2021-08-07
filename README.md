# Event-driven Microservices Workshop

Event-Driven Microservices Workshops with hands-on tutorials for working with Kafka, Java, Spring Boot, KafkaStreams and ksqlDB ...

This workshop is part of the Trivadis course [Event-Driven Microservices](https://www.trivadis.com/en/training/event-driven-microservices) as well as the [Event-Driven Architecture of the Microservices Integration and Operations CAS](https://www.bfh.ch/de/weiterbildung/cas/microservices-integration-and-operations/) at the Berner Fachhochschule.

All the workshops can be done on a container-based infrastructure using Docker Compose for the container orchestration. It can be run on a local machine or in a cloud environment. Check [01-environment](https://github.com/gschmutz/hadoop-workshop/tree/master/01-environment) for instructions on how to setup the infrastructure.


## List of Workshops

ID  | Title   | Descritpion
------------- | ------------- | -------------
2 | [Getting started with Apache Kafka](./02-working-with-kafka-broker) | Create topics from the command line, use the Console Producer and Console Consumer to publish and consume messages and show how to use `kafakcat`.
3 | [Testing Consumer Scalability and Kafka Failover](./03-understanding-failover)  | demonstrates consumer failover and broker failover and load balancing over various consumers within a consumer group
4 | [Working with Kafka from Java](./04-producing-consuming-kafka-with-java)  | learn how to produce and consume simple messages using the Kafka Java API. Secondly we will see how to produce/consume complex objects using JSON serialization.
4a | [Working with Avro and Java](./04a-working-with-avro-and-java)  | learn how to produce and consume messages using the Kafka Java API using Avro for serialization with the Confluent Schema Registry.
5 | [Using Kafka from Spring Boot](./05-producing-consuming-kafka-with-springboot)  | learn how to use Spring Boot to consume and produce from/to Kafka
5a | [Using Kafka from Spring Boot with Avro](./05a-working-with-avro-and-springboot)  | learn how to use Spring Boot to consume and produce from/to Kafka using Avro for serialization with the Confluent Schema Registry.
6 |[Using Confluent's Python client for Apache Kafka](./06-producing-consuming-kafka-with-python)  | learn how to use Python to consume and produce from/to Kafka
7 | [Working with Kafka from .NET](./07-producing-consuming-kafka-with-dotnet)  | learn how to use .NET to consume and produce from/to Kafka