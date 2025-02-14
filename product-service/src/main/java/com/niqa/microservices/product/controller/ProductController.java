package com.niqa.microservices.product.controller;

import com.niqa.microservices.product.dto.ProductRequest;
import com.niqa.microservices.product.dto.ProductResponse;
// import com.niqa.microservices.product.model.Product;
import com.niqa.microservices.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product") // Perbaikan di sini
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService; // Perbaikan di sini

    @PostMapping // Perbaikan di sini
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest) { // Perbaikan di sini
        return productService.createProduct(productRequest);
    }

    @GetMapping // Perbaikan di sini
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts(); // Perbaikan di sini
    }
}