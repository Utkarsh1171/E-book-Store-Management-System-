package com.example.Notifications_API.controller;

import com.example.Notifications_API.entity.Notification;
import com.example.Notifications_API.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    // API to send a notification
    @PostMapping("/send")
    public Notification sendNotification(@RequestParam Long userId, @RequestParam String title, @RequestParam String message) {
        return notificationService.sendNotification(userId, title, message);
    }

    // API to get all notifications for a user
    @GetMapping("/user/{userId}")
    public List<Notification> getUserNotifications(@PathVariable Long userId) {
        return notificationService.getUserNotifications(userId);
    }
}
