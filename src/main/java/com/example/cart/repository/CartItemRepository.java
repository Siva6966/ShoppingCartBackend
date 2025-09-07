package com.example.cart.repository;

import com.example.cart.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: Cva
 */
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    CartItem findByProductId(Long productId);
}
