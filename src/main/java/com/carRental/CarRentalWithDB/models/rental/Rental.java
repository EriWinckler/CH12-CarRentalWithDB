package com.carRental.CarRentalWithDB.models.rental;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Rental {
    @Id
    @GeneratedValue
    private Long id;

    private Integer howLong;
    private boolean isActive;

    public Rental() {}

    public Rental(int howLong, boolean isActive) {
        this.howLong = howLong;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Integer getHowLong() {
        return howLong;
    }

    public void setHowLong(Integer howLong) {
        this.howLong = howLong;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}