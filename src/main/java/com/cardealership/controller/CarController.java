package com.cardealership.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cardealership.entity.Car;
import com.cardealership.service.CarService;

@RestController
@RequestMapping(path = "api/v1/car")
public class CarController {

    // @Autowired
    // private CarService carService;

    // public CarController(CarService carService) {
    // this.carService = carService;
    // }

    // @GetMapping
    // public List<Car> getCars() {
    // return carService.getCars();
    // }
}
