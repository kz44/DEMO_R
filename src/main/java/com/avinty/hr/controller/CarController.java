package com.avinty.hr.controller;

import com.avinty.hr.DTO.CarDTO;
import com.avinty.hr.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
