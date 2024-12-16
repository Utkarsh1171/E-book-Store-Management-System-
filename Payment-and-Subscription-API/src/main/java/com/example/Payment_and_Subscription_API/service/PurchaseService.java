package com.example.Payment_and_Subscription_API.service;

import com.example.Payment_and_Subscription_API.entity.Ebook;
import com.example.Payment_and_Subscription_API.entity.Purchase;
import com.example.Payment_and_Subscription_API.entity.User;
import com.example.Payment_and_Subscription_API.repo.EbookRepository;
import com.example.Payment_and_Subscription_API.repo.PurchaseRepository;
import com.example.Payment_and_Subscription_API.repo.UserRepository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class PurchaseService {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final Logger logger = LoggerFactory.getLogger(PurchaseService.class);

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private EbookRepository ebookRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender mailSender;  // For sending emails

    @Transactional
    public Purchase purchaseEbook(Long userId, Long ebookId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Ebook ebook = ebookRepository.findById(ebookId)
                .orElseThrow(() -> new RuntimeException("Ebook not found"));

        Purchase purchase = Purchase.builder()
                .user(user)
                .ebook(ebook)
                .amountPaid(ebook.getPrice())
                .purchaseDate(LocalDateTime.now().format(formatter)) // Format LocalDateTime to String
                .build();
        // Save the purchase
        purchaseRepository.save(purchase);

        // Try to send purchase confirmation email
        try {
            sendPurchaseConfirmationEmail(user, ebook);
            logger.info("Purchase confirmation email sent to: " + user.getEmail());
        } catch (MailException e) {
            logger.error("Failed to send email to: " + user.getEmail(), e);
        }

        return purchase;
    }

    // Method to send a purchase confirmation email to the user
    private void sendPurchaseConfirmationEmail(User user, Ebook ebook) {
        String subject = "Purchase Confirmation: " + ebook.getTitle();
        String message = "Dear " + user.getFullName() + ",\n\n"
                + "Thank you for purchasing the E-book Store. \n" + "Title: " + ebook.getTitle() + "\nAuthor Name: " + ebook.getAuthor() + ".\n"
                + "The total amount paid is: Rs-" + ebook.getPrice() + ".\n\n"
                + "We hope you enjoy reading it!\n\nBest regards,\nYour E-book Store.";

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmail());
        mailMessage.setSubject(subject);
        mailMessage.setText(message);

        // Send email
        mailSender.send(mailMessage);
    }
}
