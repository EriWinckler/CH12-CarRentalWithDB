package com.carrental.Car.Rental.with.DB.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
@Entity
public class Vehicle {
    @Id
    @GeneratedValue
    private Long id;
    private String make;
    private String model;
    private String color;
    private int year;
    private int mileage;
    private boolean needRepair;

//    @ManyToAny
//    @JoinTable

    public Vehicle() {}

    public Vehicle(String make, String model, String color, int year,
                   int mileage, boolean needRepair) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.needRepair = needRepair;


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public boolean isNeedRepair() {
        return needRepair;
    }

    public void setNeedRepair(boolean needRepair) {
        this.needRepair = needRepair;
    }
}
