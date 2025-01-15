package com.cardealership.entity;

import java.util.HashSet;
import java.util.Set;

import com.cardealership.types.FuelType;

import jakarta.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String brandName;

    @Column
    private String model;

    @Column
    private FuelType fuel;

    @Column
    private String engine;

    @Column
    private int seats;

    @Column
    private int price;

    @Column
    private String additionalInfo;

    @Column
    private int ammount;

    @ManyToOne
    @JoinColumn(name = "dealership_vat")
    private Dealership dealership;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private Set<Booking> bookings = new HashSet<>();

    public Car() {
    }

    public Car(String brandName, String model, FuelType fuel, String engine, int seats, int price,
            String additionalInfo,
            int ammount) {
        this.brandName = brandName;
        this.model = model;
        this.fuel = fuel;
        this.engine = engine;
        this.seats = seats;
        this.price = price;
        this.additionalInfo = additionalInfo;
        this.ammount = ammount;
    }

    public Long getId() {
        return id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public FuelType getFuel() {
        return fuel;
    }

    public void setFuel(FuelType fuel) {
        this.fuel = fuel;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public int getAmmount() {
        return ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }

    public Dealership getDealership() {
        return dealership;
    }

    public void setDealership(Dealership dealership) {
        this.dealership = dealership;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }

}
