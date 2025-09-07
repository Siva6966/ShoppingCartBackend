package com.example.cart.config;

import com.example.cart.model.Product;
import com.example.cart.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Author: Cva
 */
@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initData(ProductRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                repo.saveAll(Arrays.asList(
                        new Product("Wireless Mouse", "Ergonomic 2.4G mouse", new BigDecimal("799.00")),
                        new Product("Mechanical Keyboard", "Blue switches, backlit", new BigDecimal("2999.00")),
                        new Product("USB-C Cable", "1m fast charging", new BigDecimal("249.00")),
                        new Product("Laptop Stand", "Aluminium adjustable", new BigDecimal("1499.00"))
                ));
            }
        };
    }
}
