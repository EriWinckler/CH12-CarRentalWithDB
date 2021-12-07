package com.carRental.CarRentalWithDB.controllers;

import com.carRental.CarRentalWithDB.models.rental.Rental;
import com.carRental.CarRentalWithDB.repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/rental")
public class RentalController {
    @Autowired
    private RentalRepository repository;

    public Rental getRentalById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<Rental> getRental() { return repository.findAll(); }

    @GetMapping("/howlong/{howlong}")
    public ResponseEntity<List<Rental>> getRentalByHowLong(@PathVariable Integer howLong) {
        return new ResponseEntity<>(repository.findAllByHowLong(howLong,
                Sort.by("howLong")), HttpStatus.OK);
    }

    @GetMapping("/isActive/{isActive}")
    public ResponseEntity<List<Rental>> getRentalByIsActive(@PathVariable boolean isActive) {
        return new ResponseEntity<>(repository.findAllByIsActive(isActive,
                Sort.by("name")), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Rental> createRental(@RequestBody Rental newRental) {
        return new ResponseEntity<>(repository.save(newRental),
                HttpStatus.CREATED);
    }
}
