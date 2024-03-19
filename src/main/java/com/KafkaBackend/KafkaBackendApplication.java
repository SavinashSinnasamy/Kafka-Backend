package com.KafkaBackend;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaBackendApplication.class, args);
		System.out.println("\nThe connection is established..\nThe kafka Server running successfully...");

	}
}
