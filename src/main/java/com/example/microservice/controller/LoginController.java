package com.example.microservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.microservice.dto.LoginRequest;

@Slf4j
@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class LoginController {

    @PostMapping
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        log.info("Login attempt for user: {}", loginRequest.getUserName());

        if (loginRequest.getUserName() != null && loginRequest.getPassword() != null &&
            loginRequest.getUserName().equalsIgnoreCase("admin") && 
            loginRequest.getPassword().equalsIgnoreCase("admin")) {
            return ResponseEntity.ok("Login successful");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
    }
}


