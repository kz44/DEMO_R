package com.avinty.hr.DTO;

import com.avinty.hr.enums.Category;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
  private Long carId;
  private String carBrand;
  private String carLicensePlate;
  private String carColor;
  @Enumerated(EnumType.STRING)
  private Category carCategory;


  // Renter details
  private Long renterId;
  private String renterName;
  private String renterPhoneNumber;
  private String renterEmail;


  // Rental details
  private String pickUpLocation;
  private String dropOffLocation;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
}
