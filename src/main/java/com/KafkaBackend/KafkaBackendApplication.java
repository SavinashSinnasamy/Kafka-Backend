package com.KafkaBackend;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.KafkaBackend.Config.Kafka_Configuration;

@EnableAutoConfiguration
@SpringBootApplication(exclude={Kafka_Configuration.class})
public class KafkaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaBackendApplication.class, args);
		System.out.println("\nThe connection is established..\nThe kafka Server running successfully...");

	}
}
