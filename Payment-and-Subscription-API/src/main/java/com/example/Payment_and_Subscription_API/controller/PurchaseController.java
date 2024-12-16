package com.example.Payment_and_Subscription_API.controller;

import com.example.Payment_and_Subscription_API.entity.Purchase;
import com.example.Payment_and_Subscription_API.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    // Endpoint to purchase an e-book
    @PostMapping("/ebook")
    public ResponseEntity<Purchase> purchaseEbook(@RequestParam Long userId, @RequestParam Long ebookId) {
        Purchase purchase = purchaseService.purchaseEbook(userId, ebookId);
        return ResponseEntity.status(HttpStatus.CREATED).body(purchase);
    }
}
