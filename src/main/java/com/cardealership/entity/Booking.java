package com.cardealership.entity;

import java.time.LocalDateTime;

import com.cardealership.types.BookingType;

import jakarta.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vat")
    private Citizen citizen;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    private BookingType type;

    public Booking() {
    };

    public Booking(Citizen citizen, Car car, LocalDateTime date, BookingType type) {
        this.citizen = citizen;
        this.car = car;
        this.date = date;
        this.type = type;
    }

    public Long getId() {
        return id;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public BookingType getType() {
        return type;
    }

    public void setType(BookingType type) {
        this.type = type;
    }
}
