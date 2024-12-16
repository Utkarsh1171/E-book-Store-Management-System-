package com.example.e_book_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.example.e_book_management.model") // Specify your model package
@EnableJpaRepositories("com.example.e_book_management.repository") // Specify your repository package
public class EBookManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EBookManagementApplication.class, args);
    }
}
