package com.carrental.Car.Rental.with.DB.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Store {
    private @Id long id;
    private String carModel;

    public Store() {}

    public Store(long id, String carModel) {
        this.id = id;
        this.carModel = carModel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

}
