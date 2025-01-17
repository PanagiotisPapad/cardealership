package com.cardealership.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "dealerships")
public class Dealership {
    @Id
    private String vat;

    private String name;

    private String owner;

    private String password;

    @OneToMany(mappedBy = "dealership", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Car> cars = new HashSet<>();

    // Default constructor
    public Dealership() {
    }

    public Dealership(String vat, String name, String owner, String password) {
        this.vat = vat;
        this.name = name;
        this.owner = owner;
        this.password = password;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    // Helper method to add a car
    public void addCar(Car car) {
        cars.add(car);
        car.setDealership(this);
    }

    // Helper method to remove a car
    public void removeCar(Car car) {
        cars.remove(car);
        car.setDealership(null);
    }
}