package com.example.Register_Login.controller;

import com.example.Register_Login.Dtos.ResetPasswordRequestDto;
import com.example.Register_Login.service.EmailService;
import com.example.Register_Login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/password")
public class PasswordResetController {

    private final UserService userService;
    private final EmailService emailService;

    @Autowired
    public PasswordResetController(UserService userService, EmailService emailService) {
        this.userService = userService;
        this.emailService = emailService;
    }

    @PostMapping("/send-reset-code")
    public ResponseEntity<String> sendResetCode(@RequestParam String email) {
        // Validate email format
        if (!isValidEmail(email)) {
            return ResponseEntity.badRequest().body("Invalid email format.");
        }

        try {
            // Generate and send verification code
            String verificationCode = userService.sendResetCode(email);
            emailService.sendVerificationEmail(email, verificationCode);
            return ResponseEntity.ok("Verification code sent to email.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody ResetPasswordRequestDto requestDto) {
        String email = requestDto.getEmail();
        String verificationCode = requestDto.getVerificationCode();
        String newPassword = requestDto.getNewPassword();

        // Validate new password length and content
        if (newPassword.length() < 6) {
            return ResponseEntity.badRequest().body("Password must be at least 6 characters long.");
        }
        if (!isStrongPassword(newPassword)) {
            return ResponseEntity.badRequest().body("Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character.");
        }

        try {
            userService.verifyCodeAndResetPassword(email, verificationCode, newPassword);
            return ResponseEntity.ok("Password reset successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Simple email validation method
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email != null && email.matches(emailRegex);
    }

    // Password strength validation
    private boolean isStrongPassword(String password) {
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,}$");
    }
}
