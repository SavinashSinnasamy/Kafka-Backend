package com.KafkaBackend.KafkaService;

import com.KafkaBackend.DataTransferObject.FormObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaFormProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaFormProducer.class);
    
    @Autowired
    private KafkaTemplate<String, FormObject> kafkaTemplate;



    public KafkaFormProducer(KafkaTemplate<String, FormObject> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(FormObject form){
        if(form !=  null){
       // LOGGER.info(String.format("\nMessage Sent :\n %s",form.toString()));
        Message<FormObject> message = MessageBuilder.withPayload(form).setHeader(KafkaHeaders.TOPIC,"FormFlexaUserDetails").build();
        kafkaTemplate.send(message);
    } else{
         LOGGER.info(String.format("\nMessage Sent :\n %s",form.toString()));
        }
    }


}
