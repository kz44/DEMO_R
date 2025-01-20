package com.avinty.hr.repository;

import com.avinty.hr.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

  @Query("SELECT c FROM Car c ORDER BY c.brand ASC")
  List<Car> findALlCarsSortedByBrandASC();

  @Query("SELECT c FROM Car c " +
      "WHERE LOWER(c.licensePlate) LIKE LOWER(CONCAT('%', :licensePlate, '%')) " +
      "ORDER BY c.brand ASC")
  List<Car> findByLicensePlateContainingIgnoreCase(String licensePlate);

  boolean existsCarByLicensePlateIgnoreCase(String licensePlate);
}
