package com.example.Payment_and_Subscription_API.service;

import com.example.Payment_and_Subscription_API.entity.User;
import com.example.Payment_and_Subscription_API.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {

    @Autowired
    private UserRepository userRepository;

    // Method to subscribe a user
    public User subscribeUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setIsSubscribed(true);  // Set subscription status to true
        return userRepository.save(user);
    }

    // Method to unsubscribe a user
    public User unsubscribeUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setIsSubscribed(false);  // Set subscription status to false
        return userRepository.save(user);
    }
}
