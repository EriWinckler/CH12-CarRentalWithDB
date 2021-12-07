package com.carRental.CarRentalWithDB.controllers;

import com.carRental.CarRentalWithDB.models.vehicle.Vehicle;
import com.carRental.CarRentalWithDB.repositories.VehicleRepository;
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

    public Vehicle getVehicleById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<Vehicle> getVehicles() { return repository.findAll(); }

    @GetMapping("/make/{make}")
    public ResponseEntity<List<Vehicle>> findAllByVehicleMake(@PathVariable String make) {
        return new ResponseEntity<>(repository.findAllByVehicleMake(make,
                Sort.by("make")), HttpStatus.OK);
    }

    @GetMapping("/model/{model}")
    public ResponseEntity<List<Vehicle>> findAllByVehicleModel(@PathVariable String model) {
        return new ResponseEntity<>(repository.findAllByVehicleMake(model,
                Sort.by("model")), HttpStatus.OK);
    }

    @GetMapping("/year/{year}")
    public ResponseEntity<List<Vehicle>> findAllByVehicleYear(@PathVariable int year) {
        return new ResponseEntity<>(repository.findAllByVehicleYear(year,
                Sort.by("year")), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle newVehicle) {
        return new ResponseEntity<>(repository.save(newVehicle), HttpStatus.CREATED);
    }

}

