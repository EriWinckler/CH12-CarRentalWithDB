package com.carRental.CarRentalWithDB.controllers;

import com.carRental.CarRentalWithDB.models.store.Store;
import com.carRental.CarRentalWithDB.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/store")
public class StoreController {
    @Autowired
    private StoreRepository repository;

    public Store getStoreById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<Store> getStore() { return repository.findAll(); }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Store>> findAllByStoreName(@PathVariable String name) {
        return new ResponseEntity<>(repository.findAllByStoreName(name,
                Sort.by("name")), HttpStatus.OK);
    }

    @GetMapping("/address/{address}")
    public ResponseEntity<List<Store>> findAllByStoreAddress(@PathVariable String address) {
        return new ResponseEntity<>(repository.findAllByStoreName(address,
                Sort.by("address")), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Store> createStore(@RequestBody Store newStore) {
        return new ResponseEntity<>(repository.save(newStore),
                HttpStatus.CREATED);
    }

}
