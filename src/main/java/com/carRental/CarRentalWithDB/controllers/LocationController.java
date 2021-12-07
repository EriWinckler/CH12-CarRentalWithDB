package com.carRental.CarRentalWithDB.controllers;

import com.carRental.CarRentalWithDB.models.location.Location;
import com.carRental.CarRentalWithDB.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/location")
public class LocationController {
    @Autowired
    private LocationRepository repository;

    public List<Location> getLocation() {
        return repository.findAll();
    }

    public Location getLocationById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/address/{address}")
    public ResponseEntity<List<Location>> getLocationByAddress(@PathVariable String address) {
        return new ResponseEntity<>(repository.findAllByAddress(address,
                Sort.by("address")), HttpStatus.OK);
    }

//    @GetMapping("/parkingspot/{parkingspot}")
//    public ResponseEntity<Location> getLocationByAddress(@PathVariable Integer parkingSpot) {
//        return repository.findByParkingSpot(parkingSpot).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//
//    }

    @PostMapping
    public ResponseEntity<Location> createLocation(@RequestBody Location newLocation) {
        return new ResponseEntity<>(repository.save(newLocation),
                HttpStatus.CREATED);
    }
}
