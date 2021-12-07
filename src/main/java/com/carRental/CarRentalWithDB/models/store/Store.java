package com.carRental.CarRentalWithDB.models.store;

import javax.persistence.*;

@Entity
public class Store {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String address;

//    @ManyToMany
//    @JoinTable(
//            name = "customer_store",
//            joinColumns = @JoinColumn(name = "store_id"),
//            inverseJoinColumns = @JoinColumn(name = "customer_id")
//    )

    public Store() {}

    public Store(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}