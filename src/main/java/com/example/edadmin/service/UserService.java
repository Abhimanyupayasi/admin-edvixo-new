package com.example.edadmin.service;

import com.example.edadmin.dto.UserRequest;
import com.example.edadmin.entity.User;
import com.example.edadmin.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User create(UserRequest req) {
        User user = new User();
        user.setName(req.getName());
        user.setAge(req.getAge());
        return repo.save(user);
    }

    public List<User> getAll() {
        return repo.findAll();
    }
}
