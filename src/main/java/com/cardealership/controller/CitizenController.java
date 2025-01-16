package com.cardealership.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cardealership.service.CitizenService;

@RestController
@RequestMapping("/api") // Add this to match your base URL pattern
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CitizenController {

    @Autowired
    private CitizenService citizenService;

    @PostMapping("/citizen/login")
    public ResponseEntity<String> login(@RequestParam String vat, @RequestParam String password) {
        return citizenService.login(vat, password)
                .map(citizen -> ResponseEntity.ok("Login successful"))
                .orElse(ResponseEntity.badRequest().body("Invalid credentials"));
    }
}