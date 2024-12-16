package com.example.add_to_cart.controller;

import com.example.add_to_cart.model.Cart;
import com.example.add_to_cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    // Add to cart
    @PostMapping("/add")
    public ResponseEntity<Cart> addToCart(@RequestParam Long userId, @RequestParam Long ebookId, @RequestParam int quantity) {
        Cart cartItem = cartService.addToCart(userId, ebookId, quantity);
        return ResponseEntity.ok(cartItem);
    }

    // Get all cart items for a user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Cart>> getCartByUserId(@PathVariable Long userId) {
        List<Cart> cartItems = cartService.getCartByUserId(userId);
        return ResponseEntity.ok(cartItems);
    }

    // Remove from cart
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Void> removeFromCart(@PathVariable Long id) {
        cartService.removeFromCart(id);
        return ResponseEntity.noContent().build();
    }
}
