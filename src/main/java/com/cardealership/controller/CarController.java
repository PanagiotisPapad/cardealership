package com.cardealership.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cardealership.entity.Car;
import com.cardealership.service.CarService;
import com.cardealership.types.FuelType;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/cars/search")
    public List<Car> searchCars(
            @RequestParam(required = false) String brandName,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) FuelType fuel,
            @RequestParam(required = false) Integer maxPrice) {
        return carService.searchCars(brandName, model, fuel, maxPrice);
    }

    @PostMapping("/addCar")
    public void addCar(@RequestBody Car car, @RequestParam String dealershipVat) throws Exception {
        carService.addCar(car, dealershipVat);
    }
}
