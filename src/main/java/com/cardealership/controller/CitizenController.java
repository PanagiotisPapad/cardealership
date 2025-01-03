package com.cardealership.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CitizenController {

    @GetMapping("/citizen")
    public String citizen() {
        return "This is a citizen";
    }
}
