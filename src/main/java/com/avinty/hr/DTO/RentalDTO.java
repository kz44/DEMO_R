package com.avinty.hr.DTO;

import com.avinty.hr.enums.Category;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RentalDTO {

  private Long rentalId;

  // Car details
  @NotNull(message = "Car ID cannot be null")
  private Long carId;


  // Renter details
  @NotNull(message = "Renter ID cannot be null")
  private Long renterId;


  // Rental details
  @NotBlank(message = "Pick-up location cannot be blank")
  private String pickUpLocation;

  @NotBlank(message = "Drop-off location cannot be blank")
  private String dropOffLocation;

  @NotNull(message = "Start date cannot be null")
  private LocalDateTime startDate;

  @NotNull(message = "End date cannot be null")
  private LocalDateTime endDate;
}
