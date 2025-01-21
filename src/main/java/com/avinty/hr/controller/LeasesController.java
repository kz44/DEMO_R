package com.avinty.hr.controller;


import com.avinty.hr.DTO.RentalDTO;
import com.avinty.hr.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/API/V1/leases")
public class LeasesController {

  private final RentalService rentalService;


  @GetMapping()
  public ResponseEntity<Long> getTotalRentals() {
    return ResponseEntity.ok(rentalService.getTotalRentals());
  }


  @GetMapping("/current/{userId}")
  public ResponseEntity<RentalDTO> getRentalDetailsByUserId(@PathVariable final Long userId) {
    return ResponseEntity.ok(rentalService.getRentalByUserId(userId));
  }


  @GetMapping("/{userId}")
  public ResponseEntity<List<RentalDTO>> getRentalsDetailsByUserId(@PathVariable final Long userId) {
    return ResponseEntity.ok(rentalService.getRentalsByUserId(userId));
  }


  @PostMapping()
  public ResponseEntity<RentalDTO> addNewRental(@RequestBody RentalDTO rentalDTO) {
    return ResponseEntity.ok(rentalService.addNewRental(rentalDTO));
  }
}
