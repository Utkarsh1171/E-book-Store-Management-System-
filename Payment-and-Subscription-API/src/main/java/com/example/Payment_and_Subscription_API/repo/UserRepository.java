package com.example.Payment_and_Subscription_API.repo;

import com.example.Payment_and_Subscription_API.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
