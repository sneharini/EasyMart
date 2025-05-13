package com.example.microservices.order.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

public record OrderRequest(Long id, String orderNumber,
                           String skuCode,
                           BigDecimal price,
                           Integer quantity,
                           String email, UserDetails userDetails) {

    public record UserDetails(String email, String firstName, String lastName){}
}
