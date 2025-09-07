package com.example.cart.controller;

import com.example.cart.dto.AddToCartRequest;
import com.example.cart.model.CartItem;
import com.example.cart.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Cva
 */
@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "*")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public List<CartItem> getCart() {
        return cartService.getCart();
    }

    @PostMapping("/add")
    public CartItem add(@RequestBody AddToCartRequest req) {
        return cartService.addToCart(req.getProductId(), Math.max(1, req.getQuantity()));
    }

    @PostMapping("/clear")
    public void clear() {
        cartService.clearCart();
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        cartService.removeItem(id);
    }

    @PostMapping("/{id}/quantity/{qty}")
    public CartItem update(@PathVariable Long id, @PathVariable int qty) {
        return cartService.updateQuantity(id, Math.max(1, qty));
    }
}
