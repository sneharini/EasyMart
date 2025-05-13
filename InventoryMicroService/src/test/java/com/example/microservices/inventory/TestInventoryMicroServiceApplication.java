package com.example.microservices.inventory;

import org.springframework.boot.SpringApplication;

public class TestInventoryMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(InventoryMicroServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
