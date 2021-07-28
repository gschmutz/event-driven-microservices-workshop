package com.trivadis.kafkaws.springbootkafkaproducer;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Component
public class KafkaEventProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaEventProducer.class);

    @Autowired
    private KafkaTemplate<Long, String> kafkaTemplate;

    @Value("${topic.name}")
    String kafkaTopic;

    public RecordMetadata produce(Long key, String value) {
        SendResult<Long, String> result = null;
        try {
            result = kafkaTemplate.send(kafkaTopic, key, value).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return result.getRecordMetadata();
    }
}