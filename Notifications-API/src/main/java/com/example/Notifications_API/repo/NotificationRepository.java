package com.example.Notifications_API.repo;

import com.example.Notifications_API.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findByUserId(Long userId);  // Retrieve notifications by user
}
