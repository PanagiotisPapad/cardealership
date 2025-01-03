package com.cardealership.entity;

public class Dealership {

    private int vat;
    private String brandName;
    private String owner;
    private String password;

    public Dealership(int vat, String brandName, String owner, String password) {
        this.vat = vat;
        this.brandName = brandName;
        this.owner = owner;
        this.password = password;
    }

    public int getVat() {
        return vat;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getOwner() {
        return owner;
    }

    public String getPassword() {
        return password;
    }
}
