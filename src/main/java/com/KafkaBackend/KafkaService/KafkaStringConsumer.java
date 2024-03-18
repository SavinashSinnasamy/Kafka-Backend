package com.KafkaBackend.KafkaService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaStringConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaStringConsumer.class);

    @KafkaListener(topics = "FormFlexa_Test", groupId = "receivingBanks" )
    public void getStringDetails(String message){
        LOGGER.info(String.format("\nMessage Received : \n%s",message));
    }
}
