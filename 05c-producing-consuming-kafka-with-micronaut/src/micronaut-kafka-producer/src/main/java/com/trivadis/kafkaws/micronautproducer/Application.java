package com.trivadis.kafkaws.micronautproducer;

import io.micronaut.runtime.Micronaut;
import jakarta.inject.Inject;

import java.time.LocalDateTime;

public class Application {

    @Inject
    KafkaProducer producer;

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }

    public void run(String[] args) throws Exception {
        runProducer(1000,10,1);
    }

    private void runProducer(int sendMessageCount, int waitMsInBetween, long id) throws Exception {
        Long key = (id > 0) ? id : null;

        for (int index = 0; index < sendMessageCount; index++) {
            String value =  "[" + id + "] Hello Kafka " + index + " => " + LocalDateTime.now();

            producer.send(key, value);

            // Simulate slow processing
            Thread.sleep(waitMsInBetween);

        }
    }
}
