package com.cardealership.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cardealership.entity.Citizen;
import com.cardealership.service.CitizenService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
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

    @PostMapping("/citizen/register")
    public void addCitizen(@RequestBody Citizen citizen) throws Exception {
        citizenService.addCitizen(citizen);
    }
}