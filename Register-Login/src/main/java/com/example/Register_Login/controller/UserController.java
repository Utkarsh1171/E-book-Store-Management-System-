package com.example.Register_Login.controller;

import com.example.Register_Login.model.User;
import com.example.Register_Login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        try {
            User newUser = userService.registerUser(user);
            return ResponseEntity.ok("User registered successfully: " + newUser.getFullName());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String identifier, @RequestParam String password) {
        User user = userService.loginUser(identifier, password);
        if (user != null) {
            return ResponseEntity.ok("Login successful for: " + user.getFullName());
        } else {
            return ResponseEntity.badRequest().body("Invalid username or email or password");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logoutUser(@RequestParam String username) {
        userService.logoutUser(username);
        return ResponseEntity.ok("Logout successful");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateProfile(@PathVariable Long id, @RequestBody User updatedUser) {
        Optional<User> user = userService.updateUser(id, updatedUser);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

//    @PostMapping("/reset-password/{id}")
//    public ResponseEntity<String> resetPassword(@PathVariable Long id, @RequestParam String newPassword) {
//        userService.resetPassword(id, newPassword);
//        return ResponseEntity.ok("Password reset successful");
//    }
}
