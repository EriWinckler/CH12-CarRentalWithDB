package com.carRental.CarRentalWithDB.repositories;

import com.carRental.CarRentalWithDB.models.rental.Rental;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Long> {
    List<Rental> findAllByHowLong(Integer howLong, Sort Sort);
    List<Rental> findAllByIsActive(boolean isActive, Sort sort);
}
