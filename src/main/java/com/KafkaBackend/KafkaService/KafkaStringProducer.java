package com.KafkaBackend.KafkaService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaStringProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaStringProducer.class);

    private KafkaTemplate<String,String> kafkaTemplate;

    public KafkaStringProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String Message){
        LOGGER.info(String.format("Message Sent %s", Message));
        kafkaTemplate.send("FormFlexa_test",Message);
    }
}
