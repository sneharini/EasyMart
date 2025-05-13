package com.example.ProductServiceMicroservice.controllerAdvice;

import com.example.ProductServiceMicroservice.dto.ExceptionDTO;
import com.example.ProductServiceMicroservice.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleProductNotFoundException(ProductNotFoundException ex){
        String productId = ex.getProductName();
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage("ProductNotFoundException has happened");
        exceptionDTO.setSolution("please try again with valid");

        ResponseEntity<ExceptionDTO> response = new ResponseEntity<>(
                exceptionDTO,
                HttpStatus.BAD_REQUEST
        );
        return response;
    }
}
