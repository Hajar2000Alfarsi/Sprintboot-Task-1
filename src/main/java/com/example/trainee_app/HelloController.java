package com.example.trainee_app;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    public String welcomeMessage() {
        return "Welcome to Code Creators Spring Boot Training!";
    }
}
