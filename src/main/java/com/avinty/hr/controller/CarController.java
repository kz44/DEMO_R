package com.avinty.hr.controller;

import com.avinty.hr.DTO.CarDTO;
import com.avinty.hr.service.CarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/API/V1/cars")
public class CarController {

  private final CarService carService;

  /**
   * Retrieves all cars.
   *
   * @return a list of {@link CarDTO} representing all cars.
   */
  @GetMapping()
  public ResponseEntity<List<CarDTO>> getCars() {
    return ResponseEntity.ok(carService.getAllCars());
  }

  /**
   * Retrieves a car by ID.
   *
   * @param id the ID of the car.
   * @return {@link CarDTO} representing the car.
   */
  @GetMapping("/{id}")
  public ResponseEntity<CarDTO> getCarById(@PathVariable final Long id) {
    return ResponseEntity.ok(carService.getCarById(id));
  }

  /**
   * Retrieves cars by their license plate.
   *
   * @param licensePlate the license plate to search for.
   * @return a list of {@link CarDTO} representing cars with the given license plate.
   */
  @GetMapping("/licensePlate")
  public ResponseEntity<List<CarDTO>> getCarsByLicensePlate(@RequestParam final String licensePlate) {
    return ResponseEntity.ok(carService.getCarByLicensePlate(licensePlate));
  }

  /**
   * Adds a new car.
   *
   * @param newCar the car to add.
   * @return {@link CarDTO} representing the added car.
   */
  @PostMapping()
  public ResponseEntity<CarDTO> addNewCar(@Valid @RequestBody CarDTO newCar) {
    return ResponseEntity.ok(carService.addNewCar(newCar));
  }

  /**
   * Updates an existing car by ID.
   *
   * @param id  the ID of the car to update.
   * @param dto the new car details.
   * @return {@link CarDTO} representing the updated car.
   */
  @PutMapping("/{id}")
  public ResponseEntity<CarDTO> updateCarById(@PathVariable final Long id,
                                              @Valid @RequestBody CarDTO dto) {
    return ResponseEntity.ok(carService.modifyCar(id, dto));
  }

  /**
   * Deletes a car by ID.
   *
   * @param id the ID of the car to delete.
   * @return HTTP status with no content.
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCarById(@PathVariable final Long id) {
    carService.deleteCarById(id);
    return ResponseEntity.noContent().build();
  }
}
