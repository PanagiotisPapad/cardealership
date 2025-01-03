package com.cardealership.entity;

public class Car {
    private String brandName;
    private String model;
    private String fuel;
    private String engine;
    private int seats;
    private int price;
    private String additionalInfo;
    private int ammount;

    public Car(String brandName, String model, String fuel, String engine, int seats, int price, String additionalInfo,
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

    public String getBrandName() {
        return brandName;
    }

    public String getModel() {
        return model;
    }

    public String getFuel() {
        return fuel;
    }

    public String getEngine() {
        return engine;
    }

    public int getSeats() {
        return seats;
    }

    public int getPrice() {
        return price;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public int getAmmount() {
        return ammount;
    }
}
