package com.blogging.user_service.controller;

import com.blogging.user_service.dataStore.MongoStore.Models.User;
import com.blogging.user_service.security.JwtTokenProvider;
import com.blogging.user_service.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    public UserController(UserService userService, JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        Optional<User> user = userService.authenticate(username, password);
        if (user.isPresent()) {
            String token = jwtTokenProvider.generateToken(username);
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(401).body("Invalid username or password");
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}