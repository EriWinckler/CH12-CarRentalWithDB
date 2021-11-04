package com.carrental.Car.Rental.with.DB.repositories;

import com.carrental.Car.Rental.with.DB.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
