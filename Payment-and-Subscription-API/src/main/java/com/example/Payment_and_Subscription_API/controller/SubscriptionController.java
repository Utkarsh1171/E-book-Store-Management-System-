package com.example.Payment_and_Subscription_API.controller;

import com.example.Payment_and_Subscription_API.entity.User;
import com.example.Payment_and_Subscription_API.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subscription")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    // Endpoint to subscribe a user
    @PostMapping("/subscribe")
    public ResponseEntity<User> subscribeUser(@RequestParam Long userId) {
        User user = subscriptionService.subscribeUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    // Endpoint to unsubscribe a user
    @PostMapping("/unsubscribe")
    public ResponseEntity<User> unsubscribeUser(@RequestParam Long userId) {
        User user = subscriptionService.unsubscribeUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
