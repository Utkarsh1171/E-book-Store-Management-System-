package com.example.Register_Login.service;

import com.example.Register_Login.model.User;
import com.example.Register_Login.repo.UserRepository;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class UserService {

    private Map<String, User> users = new HashMap<>();
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {

        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("Email is already in use.");
        }

        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new IllegalArgumentException("Username is already in use.");
        }

        user.setUsername(generateUniqueUsername(user.getUsername()));
        return userRepository.save(user);
    }

    private String generateUniqueUsername(String baseUsername) {
        String username = baseUsername;
        int count = 1;

        while (userRepository.findByUsername(username) != null) {
            username = baseUsername + count;
            count++;
        }
        return username;
    }

    public User loginUser(String identifier, String password) {
        User user = userRepository.findByUsername(identifier);
        if (user == null) {
            user = userRepository.findByEmail(identifier);
        }
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public void logoutUser(String username) {
        User user = users.get(username);
        if (user != null) {
            user.setLoggedIn(false);
        }
    }

    public Optional<User> updateUser(Long userId, User updatedUser) {
        return userRepository.findById(userId).map(user -> {
            user.setFirstName(updatedUser.getFirstName());
            user.setLastName(updatedUser.getLastName());
            user.setUsername(updatedUser.getUsername());
            user.setEmail(updatedUser.getEmail());
            return userRepository.save(user);
        });
    }

    private Map<String, String> verificationCodes = new HashMap<>();

    // Generate a random verification code
    private String generateVerificationCode() {
        Random random = new Random();
        int code = 100000 + random.nextInt(900000);  // 6-digit code
        return String.valueOf(code);
    }

    public String sendResetCode(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new IllegalArgumentException("User with this email does not exist.");
        }

        // Generate and store verification code
        String verificationCode = generateVerificationCode();
        verificationCodes.put(email, verificationCode);

        return verificationCode;  // Return the verification code
    }

    public void verifyCodeAndResetPassword(String email, String verificationCode, String newPassword) {
        if (!verificationCodes.containsKey(email) || !verificationCodes.get(email).equals(verificationCode)) {
            throw new IllegalArgumentException("Invalid verification code.");
        }

        // Once verified, reset the password
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new IllegalArgumentException("User with this email does not exist.");
        }

        // Encrypt the new password and update user
        user.setPassword(newPassword);
        userRepository.save(user);
        // Clear the verification code
        verificationCodes.remove(email);
    }
}
