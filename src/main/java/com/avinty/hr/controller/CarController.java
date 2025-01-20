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

  @GetMapping()
  public ResponseEntity<List<CarDTO>> getCars() {
    return ResponseEntity.ok(carService.getAllCars());
  }

  @GetMapping("/{id}")
  public ResponseEntity<CarDTO> getCarById(@PathVariable final Long id) {
    return ResponseEntity.ok(carService.getCarById(id));
  }

  @GetMapping("/licensePlate")
  public ResponseEntity<List<CarDTO>> getCarsByLicensePlate(@RequestParam final String licensePlate) {
    return ResponseEntity.ok(carService.getCarByLicensePlate(licensePlate));
  }

  @PostMapping()
  public ResponseEntity<CarDTO> addNewCar(@Valid @RequestBody CarDTO newCar) {
    return ResponseEntity.ok(carService.addNewCar(newCar));
  }

  @PutMapping("/{id}")
  public ResponseEntity<CarDTO> updateCarById(@PathVariable final Long id,
                                              @Valid @RequestBody CarDTO dto) {
    return ResponseEntity.ok(carService.modifyCar(id, dto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCarById(@PathVariable final Long id) {
    carService.deleteCarById(id);
    return ResponseEntity.noContent().build();
  }
}
