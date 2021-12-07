package com.carRental.CarRentalWithDB.repositories;

import com.carRental.CarRentalWithDB.models.store.Store;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {
    List<Store> findAllByStoreName(String name, Sort sort);
    List<Store> findAllByStoreAddress(String address, Sort sort);
}
