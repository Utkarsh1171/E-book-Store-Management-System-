package com.example.Wishlist.controller;

import com.example.Wishlist.model.Wishlist;
import com.example.Wishlist.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    // Add book to wishlist
    @PostMapping("/add")
    public ResponseEntity<String> addToWishlist(@RequestParam Long userId, @RequestParam Long bookId) {
        String response = wishlistService.addBookToWishlist(userId, bookId);
        return ResponseEntity.ok(response);
    }

    // Remove book from wishlist
    @DeleteMapping("/remove")
    public ResponseEntity<String> removeFromWishlist(@RequestParam Long userId, @RequestParam Long bookId) {
        String response = wishlistService.removeBookFromWishlist(userId, bookId);
        return ResponseEntity.ok(response);
    }

    // Get user's wishlist
    @GetMapping("/{userId}")
    public ResponseEntity<List<Wishlist>> getWishlist(@PathVariable Long userId) {
        List<Wishlist> wishlist = wishlistService.getWishlistByUserId(userId);
        return ResponseEntity.ok(wishlist);
    }
}
