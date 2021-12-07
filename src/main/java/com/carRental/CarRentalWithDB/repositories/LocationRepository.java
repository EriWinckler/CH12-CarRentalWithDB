package com.carRental.CarRentalWithDB.repositories;

import com.carRental.CarRentalWithDB.models.location.Location;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findAllByAddress(String address, Sort sort);
    List<Location> findByParkingSpot(Integer parkingSpot, Sort sort);
}
