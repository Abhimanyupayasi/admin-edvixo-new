package com.example.edadmin.controller;

import com.example.edadmin.dto.LoginRequest;
import com.example.edadmin.service.AuthService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/admin/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest req) {
        return authService.login(req.getEmail(), req.getPassword());
    }
}