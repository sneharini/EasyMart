package com.example.microservices.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@ComponentScan("~/order/event")
@EnableKafka
public class NotificationMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationMicroserviceApplication.class, args);
	}

}
