package com.cardealership.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.cardealership.service.BookingService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/book/testDrive/{carId}")
    public void bookTestDrive(
            @PathVariable Long carId,
            @RequestParam String citizenVat,
            @RequestParam String date) throws Exception {
        bookingService.createTestDriveBooking(carId, citizenVat, date);
    }

    @PostMapping("/book/purchase/{carId}")
    public void purchaseCar(
            @PathVariable Long carId,
            @RequestParam String citizenVat) throws Exception {
        bookingService.createPurchaseBooking(carId, citizenVat);
    }
}
