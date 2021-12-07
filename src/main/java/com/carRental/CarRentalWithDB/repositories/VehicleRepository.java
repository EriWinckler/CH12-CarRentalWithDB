package com.carRental.CarRentalWithDB.repositories;

import com.carRental.CarRentalWithDB.models.vehicle.Vehicle;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findAllByVehicleMake(String make, Sort sort);
    List<Vehicle> findAllByVehicleModel(String model, Sort sort);
    List<Vehicle> findAllByVehicleYear(int year, Sort sort);
}
