package com.example.cart.service;

import com.example.cart.model.CartItem;
import com.example.cart.model.Product;
import com.example.cart.repository.CartItemRepository;
import com.example.cart.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author: Cva
 */
@Service
@Transactional
public class CartService {

    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;

    public CartService(CartItemRepository cartItemRepository, ProductRepository productRepository) {
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
    }

    public List<CartItem> getCart() {
        return cartItemRepository.findAll();
    }

    public CartItem addToCart(Long productId, int quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found: " + productId));

        CartItem existing = cartItemRepository.findByProductId(productId);
        if (existing != null) {
            existing.setQuantity(existing.getQuantity() + quantity);
            return cartItemRepository.save(existing);
        }
        CartItem item = new CartItem(product, quantity);
        return cartItemRepository.save(item);
    }

    public void clearCart() {
        cartItemRepository.deleteAll();
    }

    public void removeItem(Long id) {
        cartItemRepository.deleteById(id);
    }

    public CartItem updateQuantity(Long id, int quantity) {
        CartItem item = cartItemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cart item not found: " + id));
        item.setQuantity(quantity);
        return cartItemRepository.save(item);
    }
}
