package com.carrental.Car.Rental.with.DB.repositories;

import com.carrental.Car.Rental.with.DB.models.Vehicle;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findAllByMake(String make, Sort sort);
    List<Vehicle> findAllByModel(String model, Sort sort);
}
