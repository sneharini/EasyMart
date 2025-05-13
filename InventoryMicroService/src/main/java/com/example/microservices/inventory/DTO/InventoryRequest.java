package com.example.microservices.inventory.DTO;

public record InventoryRequest(String skuCode, Integer quantity) {
}
