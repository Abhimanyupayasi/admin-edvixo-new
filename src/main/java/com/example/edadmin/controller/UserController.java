package com.example.edadmin.controller;

import com.example.edadmin.dto.UserRequest;
import com.example.edadmin.entity.User;
import com.example.edadmin.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public User create(@RequestBody UserRequest req) {
        return service.create(req);
    }

    @GetMapping
    public List<User> getAll() {
        return service.getAll();
    }
}
