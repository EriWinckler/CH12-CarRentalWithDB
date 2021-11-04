package com.carrental.Car.Rental.with.DB.repositories;

import com.carrental.Car.Rental.with.DB.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
