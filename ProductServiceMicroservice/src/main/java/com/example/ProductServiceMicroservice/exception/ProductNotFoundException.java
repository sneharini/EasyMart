package com.example.ProductServiceMicroservice.exception;


import lombok.Getter;

@Getter
public class ProductNotFoundException extends Exception{
    private String productName;
    public ProductNotFoundException(String message, String productName){
        super(message);
        this.productName = productName;
    }
}
