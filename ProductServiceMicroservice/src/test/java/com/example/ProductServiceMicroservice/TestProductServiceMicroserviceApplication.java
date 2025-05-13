package com.example.ProductServiceMicroservice;

import org.springframework.boot.SpringApplication;

public class TestProductServiceMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.from(ProductServiceMicroserviceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
