package com.example.microservices.inventory.service;

import com.example.microservices.inventory.DTO.InventoryRequest;
import com.example.microservices.inventory.DTO.InventoryResponse;
import com.example.microservices.inventory.model.Inventory;
import com.example.microservices.inventory.repository.InventoryRepository;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {


    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public InventoryResponse createInventory(InventoryRequest inventoryRequest){
        Inventory inventory = Inventory.builder()
                .skuCode(inventoryRequest.skuCode())
                .quantity(inventoryRequest.quantity()).build();
        inventoryRepository.save(inventory);
        return new InventoryResponse(inventory.getSkuCode(), inventory.getQuantity());

    }
    public boolean isInStock(String skuCode, Integer quantity){
        //find an inventory for a given skucode where quantity > 0
         return inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);
    }
}
