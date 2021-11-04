package com.carrental.Car.Rental.with.DB.controllers;

import com.carrental.Car.Rental.with.DB.models.Customer;
import com.carrental.Car.Rental.with.DB.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public @ResponseBody List<Customer> getCustomer() { return customerRepository.findAll(); }

    @PostMapping
    public @ResponseBody Customer createCustomer(@RequestBody Customer newCustomer) {
        return customerRepository.save(newCustomer);
    }

    @GetMapping("/{id}")
    public @ResponseBody Customer getOneCustomer(@PathVariable Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
