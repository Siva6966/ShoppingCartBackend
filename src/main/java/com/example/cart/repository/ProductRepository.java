package com.example.cart.repository;

import com.example.cart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: Cva
 */
public interface ProductRepository extends JpaRepository<Product, Long> {}
