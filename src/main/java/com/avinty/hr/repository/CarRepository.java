package com.avinty.hr.repository;

import com.avinty.hr.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

  /**
   * Returns all cars ordered by brand in ascending order.
   *
   * @return List of cars.
   */
  @Query("SELECT c FROM Car c ORDER BY c.brand ASC")
  List<Car> findALlCarsSortedByBrandASC();


  /**
   * Finds cars whose license plate contains the given string, case-insensitive, ordered by brand in ascending order.
   *
   * @param licensePlate the part of the license plate to search for.
   * @return a list of matching cars.
   */
  @Query("SELECT c FROM Car c " +
      "WHERE LOWER(c.licensePlate) LIKE LOWER(CONCAT('%', :licensePlate, '%')) " +
      "ORDER BY c.brand ASC")
  List<Car> findByLicensePlateContainingIgnoreCase(String licensePlate);



  /**
   * Checks if a car with the given license plate exists, case-insensitive.
   *
   * @param licensePlate the license plate to check.
   * @return true if car exists, false otherwise.
   */
  boolean existsCarByLicensePlateIgnoreCase(String licensePlate);
}
