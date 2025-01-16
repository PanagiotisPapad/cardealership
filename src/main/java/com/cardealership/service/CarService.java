package com.cardealership.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cardealership.entity.Car;
import com.cardealership.entity.Dealership;
import com.cardealership.repository.CarRepository;
import com.cardealership.repository.DealershipRepository;
import com.cardealership.types.FuelType;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private DealershipRepository dealershipRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public List<Car> searchCars(String brandName, String model, FuelType fuel, Integer maxPrice) {
        List<Car> cars = carRepository.findAll();

        return cars.stream()
                .filter(car -> brandName == null || car.getBrandName().toLowerCase().contains(brandName.toLowerCase()))
                .filter(car -> model == null || car.getModel().toLowerCase().contains(model.toLowerCase()))
                .filter(car -> fuel == null || car.getFuel() == fuel)
                .filter(car -> maxPrice == null || car.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    public void addCar(Car car, String dealershipVat) throws Exception {
        Optional<Dealership> dealership = dealershipRepository.findById(dealershipVat);
        if (dealership.isPresent()) {
            car.setDealership(dealership.get());
            carRepository.save(car);
        } else {
            throw new Exception("Dealership not found!");
        }
    }

    public void updateCarAmount(Long id, int newAmount) throws Exception {
        Optional<Car> byId = carRepository.findById(id);
        if (byId.isPresent()) {
            byId.get().setAmount(newAmount);
            carRepository.save(byId.get());
        }
    }
}