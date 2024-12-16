package com.example.Users.Repository;

import com.example.Users.Entity.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<users, Long> {

    // Method to find a user by username
    users findByUsername(String username);

    // Custom query to find users with usernames starting with a specific pattern
    @Query("SELECT u FROM users u WHERE u.username LIKE ?1%")
    List<users> getUsers(String usernamePrefix);
}
