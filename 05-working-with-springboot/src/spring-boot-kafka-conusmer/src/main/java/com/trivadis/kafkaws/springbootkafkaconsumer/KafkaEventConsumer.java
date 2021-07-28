package com.trivadis.kafkaws.springbootkafkaconsumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class KafkaEventConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaEventConsumer.class);

    @KafkaListener(topics = "${topic.name}", groupId = "simple-consumer-group")
    public void receive(ConsumerRecord<Long, String> consumerRecord) {
        String value = consumerRecord.value();
        Long key = consumerRecord.key();
        LOGGER.info("received key = '{}' with payload='{}'", key, value);
    }

}