package com.example.microservices.inventory.controller;


import com.example.microservices.inventory.DTO.InventoryRequest;
import com.example.microservices.inventory.DTO.InventoryResponse;
import com.example.microservices.inventory.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/api/inventory"})
public class InventoryController {
    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InventoryResponse createOrder(@RequestBody InventoryRequest inventoryRequest){
        return inventoryService.createInventory(inventoryRequest);
    }


    //@GetMapping({"/{skuCode}/{quantity}"})
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@RequestParam  String skuCode, @RequestParam Integer quantity){
        return inventoryService.isInStock(skuCode, quantity);
    }
}
