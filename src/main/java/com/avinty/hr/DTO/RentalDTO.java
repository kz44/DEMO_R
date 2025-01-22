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

  @NotBlank(message = "Car brand cannot be blank")
  @Size(min = 2, max = 50, message = "Car brand must be between 2 and 50 characters")
  private String carBrand;

  @NotNull(message = "License plate must not be null")
  private String carLicensePlate;

  @NotBlank(message = "Car color cannot be blank")
  private String carColor;

  @NotNull(message = "Category must not be null")
  @Enumerated(EnumType.STRING)
  private Category carCategory;


  // Renter details
  @NotNull(message = "Renter ID cannot be null")
  private Long renterId;

  @NotBlank(message = "Name cannot be blank")
  @Size(min = 2, max = 70, message = "Name must be between 2 and 70 characters")
  private String renterName;

  @NotBlank(message = "Phone number cannot be blank")
  @Pattern(regexp = "^[+]?[0-9]{10,15}$", message = "Phone number must be valid")
  private String renterPhoneNumber;

  @NotBlank(message = "Email cannot be blank")
  @Email(message = "Email must be valid")
  private String renterEmail;


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
