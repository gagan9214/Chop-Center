package com.example.repository;

import com.example.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    User findByName(@NotBlank(message = "Name Cannot Be Blank") String name);

    User findByEmail(@Email(message = "Invalid Email Formate") @NotBlank(message = "Email Cannot Be Blank") String email);
}
