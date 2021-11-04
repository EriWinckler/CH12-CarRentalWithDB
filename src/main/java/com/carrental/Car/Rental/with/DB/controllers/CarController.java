package com.carrental.Car.Rental.with.DB.controllers;

import com.carrental.Car.Rental.with.DB.models.Car;
import com.carrental.Car.Rental.with.DB.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarRepository carRepository;

    @GetMapping
    public @ResponseBody List<Car> getCars() {
        return carRepository.findAll();
    }

    @PostMapping
    public @ResponseBody Car createCar(@RequestBody Car newCar) {
        return carRepository.save(newCar);
    }

    @GetMapping("/{id}")
    public @ResponseBody Car getOneCar(@PathVariable Long id) {
        return carRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
