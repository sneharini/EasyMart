package com.example.ProductServiceMicroservice.controller;

import com.example.ProductServiceMicroservice.dto.ProductRequest;
import com.example.ProductServiceMicroservice.dto.ProductResponse;
import com.example.ProductServiceMicroservice.exception.ProductNotFoundException;
import com.example.ProductServiceMicroservice.model.Product;
import com.example.ProductServiceMicroservice.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest){
        return productService.createProduct(productRequest);
    }

    @GetMapping("/{name}")
    public ProductResponse getProductById(@PathVariable ("name") String name) throws ProductNotFoundException {
        return productService.getProductByName(name);
    }


    @GetMapping("/allproducts")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
//        try{
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        return productService.getAllProducts();
    }
}
