package com.carrental.Car.Rental.with.DB.models;

import javax.persistence.Entity;

@Entity
public class Location {
    private int storeCode;
    private int parkingSpot;

    public Location() {}

    public Location(int storeCode, int parkingSpot) {
        this.storeCode = storeCode;
        this.parkingSpot =  parkingSpot;
    }

    public int getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(int storeCode) {
        this.storeCode = storeCode;
    }

    public int getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(int parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
}
