package com.trivadis.kafkaws.micronautproducer;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.LocalDateTime;
import java.util.Properties;

@Singleton
public class KafkaProducerSync {

    @Inject
    private static  NotificationClient notificationClient;

    private static void runProducer(int sendMessageCount, int waitMsInBetween, long id) throws Exception {
        Long key = (id > 0) ? id : null;

            for (int index = 0; index < sendMessageCount; index++) {
                long time = System.currentTimeMillis();

                String msg = "[" + id + "] Hello Kafka " + index + " => " + LocalDateTime.now());

                notificationClient.send(key, msg);

                long elapsedTime = System.currentTimeMillis() - time;
                System.out.printf("[" + id + "] sent record(key=%s value=%s) time=%d\n",
                        key, msg, elapsedTime);

                // Simulate slow processing
                Thread.sleep(waitMsInBetween);
            }
    }

}
