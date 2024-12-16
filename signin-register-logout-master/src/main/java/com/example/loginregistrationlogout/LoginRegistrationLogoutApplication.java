package com.example.loginregistrationlogout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class LoginRegistrationLogoutApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginRegistrationLogoutApplication.class, args);
	}

}
