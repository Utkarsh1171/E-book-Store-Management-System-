package com.example.library_readingbook_add_get.repo;

import com.example.library_readingbook_add_get.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Additional query methods can be added here as needed
}
