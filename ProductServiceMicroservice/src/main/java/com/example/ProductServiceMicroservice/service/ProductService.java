package com.example.ProductServiceMicroservice.service;

import com.example.ProductServiceMicroservice.dto.ProductRequest;
import com.example.ProductServiceMicroservice.dto.ProductResponse;
import com.example.ProductServiceMicroservice.exception.ProductNotFoundException;
import com.example.ProductServiceMicroservice.model.Product;
import com.example.ProductServiceMicroservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j  //automatically creates a logger for your class
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();
        productRepository.save(product);
        log.info("Product created successfully");
        return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());

    }

    public List<ProductResponse> getAllProducts(){
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice()))
                .toList();
    }

    public ProductResponse getProductByName(String name) throws ProductNotFoundException {
        Optional<Product> optional =  productRepository.findByName(name);
        if(optional.isEmpty()){
            throw new ProductNotFoundException("Product Not found", name);
        }
        Product product = optional.get();

        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );

    }

}
