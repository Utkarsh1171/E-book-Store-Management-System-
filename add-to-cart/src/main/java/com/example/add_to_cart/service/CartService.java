package com.example.add_to_cart.service;

import com.example.add_to_cart.model.Cart;
import com.example.add_to_cart.repo.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Cart addToCart(Long userId, Long ebookId, int quantity) {
        Cart cartItem = Cart.builder()
                .userId(userId)
                .ebookId(ebookId)
                .quantity(quantity)
                .build();
        return cartRepository.save(cartItem);
    }

    public List<Cart> getCartByUserId(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    public void removeFromCart(Long id) {
        cartRepository.deleteById(id);
    }
}
