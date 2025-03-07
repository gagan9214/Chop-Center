package com.example.service;

import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.repository.UserRepo;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private JWTService jwtService;

    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);

    @Autowired
    private UserRepo repo;

    @Autowired
    private AuthenticationManager authManager;


    public User addUser(User user) {

        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }


    public String verify(User user) {
        System.out.println("verify called");

        User storedUser = repo.findByEmail(user.getEmail());
        if (storedUser == null) {
            return "User not found"; // 401 Unauthorized
        }

        Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));
        if(auth.isAuthenticated())
        {
            return jwtService.generateToken(user.getEmail());
        }
        return "fail";
    }
}
