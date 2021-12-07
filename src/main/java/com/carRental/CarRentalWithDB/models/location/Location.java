package com.carRental.CarRentalWithDB.models.location;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Location {
    @Id
    @GeneratedValue
    private Long id;

    private String address;
    private Integer parkingSpot;

    public Location () {}

    public Location(String address, Integer parkingSpot) {
        this.address = address;
        this.parkingSpot = parkingSpot;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(Integer parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
}
