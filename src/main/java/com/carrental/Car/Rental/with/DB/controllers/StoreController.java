package com.carrental.Car.Rental.with.DB.controllers;

import com.carrental.Car.Rental.with.DB.models.Store;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/api/store")
public class StoreController {
    private Map<Long, Store> cars = new HashMap<>();
    private AtomicInteger idCounter = new AtomicInteger();

    public StoreController() {
        long id = idCounter.incrementAndGet();
        cars.put(id, new Store(id, "Kia Stinger"));
        cars.put(id, new Store(id, "Hyundai Palisade"));
        cars.put(id, new Store(id, "Nissan Skyline"));
    }

    @GetMapping
    public List<Store> all() {
        return new ArrayList<Store>(cars.values());
    }

    @PostMapping
    public Store newStore(@RequestBody Store newStore) {
        long id = idCounter.incrementAndGet();
        newStore.setId(id);
        cars.put(id, newStore);
        return newStore;
    }

    @GetMapping("/{id}")
    public Store car(@PathVariable long id) {
        return cars.get(id);
    }

    @PutMapping("/{id}")
    public Store updateStore(@PathVariable long id,
                             @RequestBody Store updateStore) {

        Store car = cars.get(id);
        updateStore.getClass().getDeclaredFields();

        if(car == null) {
            return car;
        }

        if(updateStore.getCarModel() != null) {
            car.setCarModel(updateStore.getCarModel());
        }

        return car;
    }

    @DeleteMapping("/{id}")
    public void deleteStore(@PathVariable long id) {
        cars.remove(id);
    }
}
