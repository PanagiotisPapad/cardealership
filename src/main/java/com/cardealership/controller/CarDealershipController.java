package com.cardealership.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarDealershipController {

    @GetMapping("/car")
    public String car() {
        return "This is my car";
    }
}
