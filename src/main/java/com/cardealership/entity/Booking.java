package com.cardealership.entity;

import java.util.ArrayList;

public class Booking {

    private Citizen citizen;
    private Car car;
    private String date;
    private int time;

    public Booking(Citizen citizen, Car car, String date, int time) {
        this.citizen = citizen;
        this.car = car;
        this.date = date;
        this.time = time;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

}
