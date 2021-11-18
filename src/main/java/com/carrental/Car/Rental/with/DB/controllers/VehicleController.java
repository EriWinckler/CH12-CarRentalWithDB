package com.carrental.Car.Rental.with.DB.controllers;

import com.carrental.Car.Rental.with.DB.models.Vehicle;
import com.carrental.Car.Rental.with.DB.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {
    @Autowired
    private VehicleRepository repository;

    @GetMapping
    public @ResponseBody List<Vehicle> getVehicles() {
        return repository.findAll();
    }

    @GetMapping("/{make}")
    public ResponseEntity<List<Vehicle>> findAllByMake(@PathVariable String make) {
        return new ResponseEntity<>(repository.findAllByMake(make, Sort.by(
                "name")), HttpStatus.OK);
    }

    @GetMapping("/{model}")
    public ResponseEntity<List<Vehicle>> findAllByModel(@PathVariable String model) {
        return new ResponseEntity<>(repository.findAllByMake(model, Sort.by(
                "name")), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Vehicle> createVehicle (@RequestBody Vehicle newVehicle) {
        return new ResponseEntity<>(repository.save(newVehicle),
                HttpStatus.CREATED);
    }

    //    @PutMapping
    private Long id;
    private String make;
    private String model;
    private String color;
    private int year;
    private int mileage;
    private boolean needRepair;
    @PutMapping("/{id}")
    public @ResponseBody Vehicle updateVehicle (@PathVariable Long id,
                                                @RequestBody Vehicle updates) {
        Vehicle vehicle =
                repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (updates.getMake() != null) vehicle.setMake(updates.getMake());
        if (updates.getModel() != null) vehicle.setModel(updates.getModel());
        if (updates.getColor() != null) vehicle.setColor(updates.getColor());
//        if (updates.getYear() != null) vehicle.setYear(updates.getYear());
//        if (updates.getMileage() != null) vehicle.setMileage(updates.getMileage());
//        if (updates.isNeedRepair()) vehicle.setNeedRepair(updates.isNeedRepair());

        return repository.save(vehicle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }
}
