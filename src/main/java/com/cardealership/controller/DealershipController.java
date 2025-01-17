package com.cardealership.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cardealership.entity.Dealership;
import com.cardealership.service.DealershipService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DealershipController {

    @Autowired
    private DealershipService dealershipService;

    @PostMapping("/dealership/login")
    public ResponseEntity<String> login(@RequestParam String vat, @RequestParam String password) {
        return dealershipService.login(vat, password)
                .map(dealership -> ResponseEntity.ok("Login successful"))
                .orElse(ResponseEntity.badRequest().body("Invalid credentials"));
    }

    @PostMapping("/dealership/register")
    public void addDealership(@RequestBody Dealership dealership) throws Exception {
        dealershipService.addDealership(dealership);
    }
}