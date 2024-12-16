package com.example.loginregistrationlogout.service;

import com.example.loginregistrationlogout.dto.UserRegistrationDto;
import com.example.loginregistrationlogout.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User save(UserRegistrationDto registrationDto);
}
