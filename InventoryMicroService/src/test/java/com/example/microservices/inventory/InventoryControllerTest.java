package com.example.microservices.inventory;

import com.example.microservices.inventory.controller.InventoryController;
import com.example.microservices.inventory.service.InventoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when; // To define mock behavior
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.verify; // To check method call

class InventoryControllerTest {

    @Mock
    private InventoryService inventoryService; // 1. Create a mock of InventoryService

    @InjectMocks
    private InventoryController inventoryController; // 2. Inject the mock into controller

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // 3. Initialize mocks before each test
    }

    @Test
    void isInStock_ShouldReturnTrue_WhenItemIsAvailable() {
        // Arrange
        String skuCode = "ABC123";
        int quantity = 5;

        when(inventoryService.isInStock(skuCode, quantity)).thenReturn(true); // 4. Mock behavior

        // Act
        boolean result = inventoryController.isInStock(skuCode, quantity);

        // Assert
        assertTrue(result); // 5. Verify that result is true
        verify(inventoryService).isInStock(skuCode, quantity); // 6. Verify service method was called
    }

    @Test
    void isInStock_ShouldReturnFalse_WhenItemIsNotAvailable() {
        // Arrange
        String skuCode = "XYZ789";
        int quantity = 10;

        when(inventoryService.isInStock(skuCode, quantity)).thenReturn(false);

        // Act
        boolean result = inventoryController.isInStock(skuCode, quantity);

        // Assert
        assertFalse(result);
        verify(inventoryService).isInStock(skuCode, quantity);
    }
}
