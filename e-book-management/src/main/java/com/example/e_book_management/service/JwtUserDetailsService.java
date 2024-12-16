package com.example.e_book_management.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("username".equals(username)) {
            return new User("username", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
                    //eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYXZhaW51c2UiLCJpYXQiOjE3MjczNDIxNDYsImV4cCI6MTcyNzM0MzE0Nn0.ioc_thZDiUQmyzqbQwSELaugL9fbJL8OWHcKWkEnZ6c"

                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
