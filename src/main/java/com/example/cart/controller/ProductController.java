package com.example.cart.controller;

import com.example.cart.model.Product;
import com.example.cart.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Cva
 */
@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> all() {
        return productRepository.findAll();
    }
}
