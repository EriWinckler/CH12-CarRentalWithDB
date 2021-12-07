package com.carRental.CarRentalWithDB.controllers;

import com.carRental.CarRentalWithDB.models.customer.Customer;
import com.carRental.CarRentalWithDB.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository repository;

    public Customer getCustomerById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<Customer> getCustomers() {
        return repository.findAll();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Customer>> getAllCustomerByName(@PathVariable String name) {
        return new ResponseEntity<>(repository.findAllByName(name, Sort.by(
                "name")), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public @ResponseBody Customer getOneCustomer(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/licensenumber/{licencenumber}")
    public ResponseEntity<List<Customer>> getAllCustomerByLicenseNUmber(@PathVariable String licenseNumber) {
        return new ResponseEntity<>(repository.findAllByLicenseNumber(licenseNumber,
                Sort.by(
                        "name")), HttpStatus.OK);
    }
}