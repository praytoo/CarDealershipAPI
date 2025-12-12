package com.pluralsight.workshop9.models;

public class Vehicle {
    private Integer vin;
    private Integer year;
    private String make;
    private String model;
    private String type; //car, truck, etc.
    private String color;
    private Integer odometer;
    private Integer price;
    private boolean sold;

    public void setOdometer(Integer odometer) {
        this.odometer = odometer;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public Vehicle() {
    }

    @Override
    public String toString() {
        return "Vehicle: " +  "\n" +
                "vin = " + vin + "\n" +
                "year = " + year + "\n" +
                "make = " + make + "\n" +
                "model = " + model + "\n" +
                "vehicleType = " + type + "\n" +
                "color = " + color + "\n" +
                "odometer = " + odometer + "\n" +
                "price = " + price + "\n" +
                "sold = " + sold + "-------\n";
    }

    public Vehicle(Integer vin, Integer year, String make, String model, String type, String color, Integer odometer, Integer price, boolean sold) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.type = type;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
        this.sold = sold;
    }

    public Vehicle(Integer vin, Integer year, String make, String model, String type, String color, Integer odometer, Integer price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.type = type;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    public Integer getVin() {
        return vin;
    }

    public void setVin(Integer vin) {
        this.vin = vin;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


}
