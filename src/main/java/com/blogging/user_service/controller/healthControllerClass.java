package com.blogging.user_service.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/user")
public class healthControllerClass {
    @GetMapping("/health")
    public ResponseEntity<String> checkHealth() {
        return new ResponseEntity<>("User Service is up and running", HttpStatus.OK);
    }
}
