package com.KafkaBackend.KafkaService;

import com.KafkaBackend.DataTransferObject.FormObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class KafkaFormConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaFormConsumer.class);
//Only one instance is created, once a message record is sent it can be read by entering the form id,
    //if the session is terminated and the next form id is entered only the next form can be read. unless it doesn't allow to read other forms.
// All the forms after the pushed message can be read in a line

    @KafkaListener(topics = "FormFlexaUserDetails", groupId = "requestingBanks" )
    public void getFormDetails(FormObject form) {
        Scanner input = new Scanner(System.in);
        String lowerCaseValue;
        boolean loop = true;
        while (loop){
            System.out.print("\nEnter Form ID : ");
            String idNo = input.next();
            if (idNo.equals(form.getFormId())) {
                LOGGER.info(String.format("\n\n" +
                                "\n===================================" +
                                "\n\t\tApache Kafka Topic " +
                                "\n===================================" +
                                "\n%s", form.toString()));
                System.out.println("===================================");
            } else {
                System.out.println("No details provided, Check for the form Id and Try Again..");
            }
            System.out.print("Do you need to view again ? (y/n) : ");
            String value = input.next();
            lowerCaseValue = value.toLowerCase();
            if(lowerCaseValue.equals("n")){
                System.out.println("Kafka Topic server ended..");
                loop = false;

            } else if (!lowerCaseValue.equals("y")  ) {
                System.out.println("Invalid Input, Try again..");
                loop = false;
            }
        }
    }
}
