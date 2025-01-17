package com.cardealership.entity;

import java.util.HashSet;
import java.util.Set;

import com.cardealership.types.FuelType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

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
    private int amount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dealership_vat")
    @JsonBackReference
    private Dealership dealership;

    @JsonProperty("dealershipVat")
    public String getDealershipVat() {
        return dealership != null ? dealership.getVat() : null;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Booking> bookings = new HashSet<>();

    public Car() {
    }

    public Car(String brandName, String model, FuelType fuel, String engine, int seats, int price,
            String additionalInfo,
            int amount) {
        this.brandName = brandName;
        this.model = model;
        this.fuel = fuel;
        this.engine = engine;
        this.seats = seats;
        this.price = price;
        this.additionalInfo = additionalInfo;
        this.amount = amount;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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
