package com.pluralsight.workshop9.models;

public class Cart {
    private int VIN;
    private String make;
    private String model;
    private double price;
    private String color;
    private String type;
    private int mileage;
    private int year;
    private boolean sold;

    @Override
    public String toString() {
        return "Cart: " +  "\n" +
                "vin = " + VIN + "\n" +
                "year = " + year + "\n" +
                "make = " + make + "\n" +
                "model = " + model + "\n" +
                "vehicleType = " + type + "\n" +
                "color = " + color + "\n" +
                "odometer = " + mileage + "\n" +
                "price = " + price + "\n" +
                "sold = " + sold + "\n" + "-------\n";
    }

    public Cart(int VIN, String make, String model, double price, String color, String type, int mileage, int year, boolean sold) {
        this.VIN = VIN;
        this.make = make;
        this.model = model;
        this.price = price;
        this.color = color;
        this.type = type;
        this.mileage = mileage;
        this.year = year;
        this.sold = sold;
    }
}
