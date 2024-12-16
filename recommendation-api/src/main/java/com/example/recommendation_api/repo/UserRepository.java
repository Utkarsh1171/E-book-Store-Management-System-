package com.example.recommendation_api.repo;

import com.example.recommendation_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Additional query methods can be added here as needed
}
