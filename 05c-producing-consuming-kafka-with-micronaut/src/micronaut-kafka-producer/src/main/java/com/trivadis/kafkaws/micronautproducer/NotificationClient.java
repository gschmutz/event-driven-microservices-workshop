package com.trivadis.kafkaws.micronautproducer;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.http.annotation.Body;

@KafkaClient
public interface NotificationClient {

    @Topic("topic")
    void sned (@Body String message);
}
