package com.carRental.CarRentalWithDB.repositories;

import com.carRental.CarRentalWithDB.models.customer.Customer;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findAllByName(String name, Sort sort);
    List<Customer> findAllByLicenseNumber(String licenseNumber, Sort sort);
}

