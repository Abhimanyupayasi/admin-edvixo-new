package com.example.edadmin.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Welcome to Admin API from Edvixo 🚀\nThanks, Team Edvixo";
    }
}