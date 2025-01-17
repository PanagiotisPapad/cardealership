package com.cardealership.entity;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table(name = "citizens")
public class Citizen {
    @Id
    private String vat;

    private String firstName;

    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;

    @OneToMany(mappedBy = "citizen", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Booking> bookings = new HashSet<>();

    // Default constructor
    public Citizen() {
    }

    public Citizen(String vat, String firstName, String lastName, String email, String password) {
        this.vat = vat;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }

    // Helper method to add a booking
    public void addBooking(Booking booking) {
        bookings.add(booking);
        booking.setCitizen(this);
    }

    // Helper method to remove a booking
    public void removeBooking(Booking booking) {
        bookings.remove(booking);
        booking.setCitizen(null);
    }

    // Helper method to get full name
    public String getFullName() {
        return firstName + " " + lastName;
    }
}