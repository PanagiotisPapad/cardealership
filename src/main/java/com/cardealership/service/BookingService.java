package com.cardealership.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.cardealership.entity.Booking;
import com.cardealership.entity.Car;
import com.cardealership.entity.Citizen;
import com.cardealership.repository.BookingRepository;
import com.cardealership.repository.CarRepository;
import com.cardealership.repository.CitizenRepository;
import com.cardealership.types.BookingType;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CitizenRepository citizenRepository;

    public void createTestDriveBooking(Long carId, String citizenVat, String date) throws Exception {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new Exception("Car not found"));

        Citizen citizen = citizenRepository.findById(citizenVat)
                .orElseThrow(() -> new Exception("Citizen not found"));

        LocalDateTime bookingDate = LocalDateTime.parse(date);

        // Check if car is available for test drive on that date
        boolean isAvailable = checkTestDriveAvailability(carId, bookingDate);
        if (!isAvailable) {
            throw new Exception("Car is not available for test drive at this time");
        }

        Booking booking = new Booking(citizen, car, bookingDate, BookingType.TEST_DIRVE);
        bookingRepository.save(booking);
    }

    private boolean checkTestDriveAvailability(Long carId, LocalDateTime date) {
        List<Booking> existingBookings = bookingRepository.findAll();

        return existingBookings.stream()
                .filter(b -> b.getCar().getId().equals(carId))
                .filter(b -> b.getType() == BookingType.TEST_DIRVE)
                .noneMatch(b -> b.getDate().equals(date));
    }

    public void createPurchaseBooking(Long carId, String citizenVat) throws Exception {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new Exception("Car not found"));

        Citizen citizen = citizenRepository.findById(citizenVat)
                .orElseThrow(() -> new Exception("Citizen not found"));

        // Check if car is available for purchase
        if (car.getAmount() <= 0) {
            throw new Exception("Car is not available for purchase");
        }

        // Create purchase booking
        Booking booking = new Booking(citizen, car, LocalDateTime.now(), BookingType.PURCHASE);
        bookingRepository.save(booking);

        // Update car amount
        car.setAmount(car.getAmount() - 1);
        carRepository.save(car);
    }
}
