package com.example.byteSoul.userService.controller;

import com.example.byteSoul.userService.Login.LoginRequest;
import com.example.byteSoul.userService.Login.LoginResponse;
import com.example.byteSoul.userService.entity.Role;
import com.example.byteSoul.userService.entity.User;
import com.example.byteSoul.userService.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.registerUser(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return service.getUser(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<User> getByRole(@RequestParam(required = false) Role role) {
        if (role != null) return service.getUsersByRole(role);
        return service.getUsersByRole(Role.CUSTOMER); // default
    }
    @PostMapping("/login")
    public String login (@RequestBody LoginRequest loginRequest){
        return service.isValidUser(loginRequest);
    }
    @PostMapping("/phone")
    public User getUser(@RequestBody User user){
        return service.getPhone(user);
    }
}

