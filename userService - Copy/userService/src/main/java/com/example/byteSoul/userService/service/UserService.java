package com.example.byteSoul.userService.service;

import com.example.byteSoul.userService.Login.LoginRequest;
import com.example.byteSoul.userService.Login.LoginResponse;
import com.example.byteSoul.userService.entity.Role;
import com.example.byteSoul.userService.entity.User;
import com.example.byteSoul.userService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repo;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repo.save(user);
    }

    public Optional<User> getUser(Long id) {
        return repo.findById(id);
    }

    public List<User> getUsersByRole(Role role) {
        return repo.findAll().stream()
                .filter(u -> u.getRole().equals(role))
                .toList();
    }
    public String isValidUser(LoginRequest loginRequest){
        User user = repo.findByEmail(loginRequest.getEmail()).orElseThrow(() -> new RuntimeException("User Not Found"));
        if(passwordEncoder.matches(loginRequest.getPassword() , user.getPassword())){
           return "Successfull";

        }
        throw new RuntimeException("Invalid Credentials");
    }
    public User getPhone(User user){
        return repo.findByPhone(user.getPhone()).orElseThrow(() -> new RuntimeException("Not Found"));
    }
}

