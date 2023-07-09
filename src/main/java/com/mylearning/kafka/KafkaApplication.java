package com.mylearning.kafka;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

import java.time.LocalDateTime;

@SpringBootApplication
public class KafkaApplication {

	public static void main(String[] args) {

		SpringApplication.run(KafkaApplication.class, args);
	}

	CommandLineRunner commandLineRunner(
			KafkaTemplate<String,Message >kafkaTemplate
	){
		Message message = new Message(
				"Hi",
				LocalDateTime.now()
		);
		return args -> {
		kafkaTemplate.send(				"mylearning", message);
		};
	}

}
