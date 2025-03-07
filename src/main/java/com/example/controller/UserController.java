package com.example.controller;

import com.example.model.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.example.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class UserController {

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Autowired
    private UserService service;

    @PostMapping("/signup")
    public User signup(@Valid @RequestBody User user) {
        System.out.println("signup called");

        return service.addUser(user);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@Valid @RequestBody User user) {
        System.out.println("signin called");
         return ResponseEntity.ok(service.verify(user));
    }

    @GetMapping("/userslist")
    public List<User> getUsers() {
        System.out.println("getUsers called");

        return service.getAllUsers();

    }
}
