package com.example.edadmin.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.edadmin.config.JwtUtil;

import java.util.*;

@Service
public class AuthService {

    private final JdbcTemplate jdbcTemplate;

    public AuthService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Map<String, String> login(String email, String password) {

        String sql = "SELECT * FROM admin_edvixo WHERE email = ?";
        List<Map<String, Object>> users = jdbcTemplate.queryForList(sql, email);

        if (users.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        Map<String, Object> user = users.get(0);

        if (!user.get("password").toString().equals(password)) {
            throw new RuntimeException("Wrong password");
        }

        String accessToken = JwtUtil.generateToken(email);
        String refreshToken = UUID.randomUUID().toString();

        jdbcTemplate.update(
            "UPDATE admin_edvixo SET refresh_token=?, refresh_token_expiry=NOW() + INTERVAL '7 days' WHERE email=?",
            refreshToken, email
        );

        return Map.of(
            "accessToken", accessToken,
            "refreshToken", refreshToken
        );
    }
}