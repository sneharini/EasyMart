package com.example.ProductServiceMicroservice.repository;

import com.example.ProductServiceMicroservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {
    Optional<Product> findByName(String name);


}
