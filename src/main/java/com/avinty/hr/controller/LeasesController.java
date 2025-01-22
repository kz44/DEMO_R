package com.avinty.hr.controller;


import com.avinty.hr.DTO.RentalDTO;
import com.avinty.hr.exception.EntityNotFoundException;
import com.avinty.hr.service.RentalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/API/V1/leases")
public class LeasesController {

  private final RentalService rentalService;


  /**
   * Retrieves the total number of rentals in the system.
   *
   * @return a {@link ResponseEntity} containing the total number of rentals.
   */
  @GetMapping()
  public ResponseEntity<Long> getTotalRentals() {
    return ResponseEntity.ok(rentalService.getTotalRentals());
  }


  /**
   * Retrieves the current rental details for a specific user by their user ID.
   *
   * @param userId the ID of the user.
   * @return a {@link ResponseEntity} containing the current rental details as a {@link RentalDTO}.
   * @throws EntityNotFoundException if no current rental is found for the user.
   */
  @GetMapping("/current/{userId}")
  public ResponseEntity<RentalDTO> getRentalDetailsByUserId(@PathVariable final Long userId) {
    return ResponseEntity.ok(rentalService.getRentalByUserId(userId));
  }


  /**
   * Retrieves all rentals for a specific user by their user ID.
   *
   * @param userId the ID of the user.
   * @return a {@link ResponseEntity} containing a list of {@link RentalDTO} for the user.
   * @throws EntityNotFoundException if no rentals are found for the user.
   */
  @GetMapping("/{userId}")
  public ResponseEntity<List<RentalDTO>> getRentalsDetailsByUserId(@PathVariable final Long userId) {
    return ResponseEntity.ok(rentalService.getRentalsByUserId(userId));
  }


  /**
   * Adds a new rental to the system.
   *
   * @param rentalDTO the details of the new rental.
   * @return a {@link ResponseEntity} containing the newly added {@link RentalDTO}.
   */
  @PostMapping()
  public ResponseEntity<RentalDTO> addNewRental(@Valid @RequestBody RentalDTO rentalDTO) {
    return ResponseEntity.ok(rentalService.addNewRental(rentalDTO));
  }
}
