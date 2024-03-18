package com.KafkaBackend.KafkaController;

import com.KafkaBackend.DataTransferObject.FormObject;
import com.KafkaBackend.KafkaService.KafkaFormProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/KafkaForm")
@CrossOrigin
public class KafkaFormControls {
    @Autowired
    private KafkaFormProducer kafkaFormProducer;

    @Autowired
    public KafkaFormControls(KafkaFormProducer kafkaFormProducer) {
        this.kafkaFormProducer = kafkaFormProducer;
    }

    @PostMapping("/sendMessage")
    public ResponseEntity<String> sendMessage(@RequestBody FormObject form) {
        try {
            kafkaFormProducer.sendMessage(form);
            return ResponseEntity.ok("The form details sent to kafka topic successfully..");
        } catch (Exception e) {
            // Handle exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred: " + e.getMessage());
        }
    }
}
