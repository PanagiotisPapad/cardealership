package com.cardealership.entity;

public class Citizen {

    private int vat;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public Citizen(int vat, String firstName, String lastName, String email, String password) {
        this.vat = vat;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public int getVat() {
        return vat;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
