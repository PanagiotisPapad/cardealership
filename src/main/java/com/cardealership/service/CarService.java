package com.cardealership.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cardealership.entity.Car;
import com.cardealership.repository.CarRepository;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public void addCar(Car car) {
        carRepository.save(car);
    }
}