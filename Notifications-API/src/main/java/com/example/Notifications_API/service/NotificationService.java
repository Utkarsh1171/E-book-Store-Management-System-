package com.example.Notifications_API.service;

import com.example.Notifications_API.entity.Notification;
import com.example.Notifications_API.repo.NotificationRepository;
import com.example.Notifications_API.repo.UserRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender mailSender;  // For sending emails

    public Notification sendNotification(Long userId, String title, String message) {
        var user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));

        Notification notification = Notification.builder()
                .user(user)
                .title(title)
                .message(message)
                .sent(true)
                .timestamp(LocalDateTime.now().toString())
                .build();

        // Send email notification
        sendEmail(user.getEmail(), title, message);

        return notificationRepository.save(notification);
    }

    // Method to send email
    private void sendEmail(String to, String subject, String body) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body);

            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    // Get notifications for a user
    public List<Notification> getUserNotifications(Long userId) {
        return notificationRepository.findByUserId(userId);
    }
}
