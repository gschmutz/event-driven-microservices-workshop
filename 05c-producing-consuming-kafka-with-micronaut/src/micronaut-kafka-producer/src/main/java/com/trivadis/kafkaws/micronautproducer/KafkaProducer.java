package com.trivadis.kafkaws.micronautproducer;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.http.annotation.Body;

@KafkaClient
public interface KafkaProducer {

    @Topic("test-java-micronaut-topic")
    void send (@KafkaKey Long id, @Body String message);
}
