package com.example.microservices.inventory;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class InventoryMicroServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}
