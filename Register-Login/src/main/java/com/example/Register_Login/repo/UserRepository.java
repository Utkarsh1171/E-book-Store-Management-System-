package com.example.Register_Login.repo;

import com.example.Register_Login.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findByEmail(String email);

    boolean existsByEmail(String email);

}
