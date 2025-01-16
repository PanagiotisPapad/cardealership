package com.cardealership.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import com.cardealership.entity.Car;
import com.cardealership.entity.Citizen;
import com.cardealership.entity.Dealership;
import com.cardealership.service.CarService;
import com.cardealership.service.CitizenService;
import com.cardealership.service.DealershipService;
import com.cardealership.types.FuelType;

// @Configuration
// public class DealershipConfig implements CommandLineRunner {

// @Autowired
// private CitizenService citizenService;

// @Autowired
// private CarService carService;

// @Autowired
// private DealershipService dealershipService;

// @Override
// public void run(String... args) throws Exception {
// Citizen c1 = new Citizen("111222333", "George", "Papadopoulos",
// "george@mail.com", "pass123");
// Citizen c2 = new Citizen("444555666", "Maria", "Nikolaou", "maria@mail.com",
// "pass456");

// citizenService.addCitizen(c1);
// citizenService.addCitizen(c2);

// Create dealerships
// Dealership d1 = new Dealership("123456789", "AutoMax", "John Smith",
// "pass123");
// Dealership d2 = new Dealership("987654321", "CarWorld", "Mary Johnson",
// "pass456");

// dealershipService.addDealership(d1);
// dealershipService.addDealership(d2);

// // Create cars for AutoMax
// Car c1 = new Car("Toyota", "Corolla", FuelType.PETROL, "1.6L", 5, 25000,
// "Basic model with AC", 3);
// Car c2 = new Car("Honda", "Civic", FuelType.HYBRID, "1.5L", 5, 28000, "Hybrid
// with leather seats", 2);
// c1.setDealership(d1);
// c2.setDealership(d1);

// // Create cars for CarWorld
// Car c3 = new Car("Tesla", "Model 3", FuelType.ELECTRIC, "Dual Motor", 5,
// 45000, "Long range version", 2);
// Car c4 = new Car("BMW", "320i", FuelType.PETROL, "2.0L", 5, 42000, "Sport
// package", 1);
// c3.setDealership(d2);
// c4.setDealership(d2);

// carService.addCar(c1);
// carService.addCar(c2);
// carService.addCar(c3);
// carService.addCar(c4);
// }
// }