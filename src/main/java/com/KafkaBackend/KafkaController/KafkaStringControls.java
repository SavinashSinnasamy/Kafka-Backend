/*
package com.KafkaBackend.KafkaController;

import com.KafkaBackend.KafkaService.KafkaStringProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafkaString")
public class KafkaStringControls {

    private KafkaStringProducer kafkaService;
    
    public KafkaStringControls(KafkaStringProducer kafkaObject){
        this.kafkaService = kafkaObject;
    }

    @GetMapping("/sendMessage")
    public ResponseEntity<String> publishMessage(@RequestParam("message") String message){
        kafkaService.sendMessage(message);
        return ResponseEntity.ok("Form Details Sent to the kafka topic..");
    }

}
*/
