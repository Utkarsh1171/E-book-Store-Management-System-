package com.example.Notifications_API.repo;

import com.example.Notifications_API.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Additional query methods can be added here as needed
}
