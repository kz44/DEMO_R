package com.avinty.hr.mapper;

import com.avinty.hr.DTO.RentalDTO;
import com.avinty.hr.model.Car;
import com.avinty.hr.model.Rental;
import com.avinty.hr.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RentalMapper {

  /**
   * Converts a {@link Rental} entity to a {@link RentalDTO}.
   *
   * @param entity the {@link Rental} entity to convert.
   * @return a {@link RentalDTO} representing the rental data.
   */
  public RentalDTO toDTO(Rental entity) {
    return RentalDTO.builder()
        .rentalId(entity.getId())

        // Car details
        .carId(entity.getCar().getId())
        .carBrand(entity.getCar().getBrand())
        .carLicensePlate(entity.getCar().getLicensePlate())
        .carColor(entity.getCar().getColor())
        .carCategory(entity.getCar().getCategory())

        // User details (renter)
        .renterId(entity.getUser().getId())
        .renterName(entity.getUser().getName())
        .renterPhoneNumber(entity.getUser().getPhoneNumber())
        .renterEmail(entity.getUser().getEmail())

        // Rental details
        .pickUpLocation(entity.getPickUpLocation())
        .dropOffLocation(entity.getDropOffLocation())
        .startDate(entity.getStartDate())
        .endDate(entity.getEndDate())

        .build();
  }


  /**
   * Converts a {@link RentalDTO} to a {@link Rental} entity.
   *
   * @param dto the {@link RentalDTO} to convert.
   * @return a {@link Rental} entity representing the rental data.
   */
  public Rental toEntity(RentalDTO dto) {

    // Car details
    Car car = Car.builder()
        .id(dto.getCarId())
        .brand(dto.getCarBrand())
        .licensePlate(dto.getCarLicensePlate())
        .color(dto.getCarColor())
        .category(dto.getCarCategory())
        .build();

    // User details (renter)
    User user = User.builder()
        .id(dto.getRenterId())
        .name(dto.getRenterName())
        .phoneNumber(dto.getRenterPhoneNumber())
        .email(dto.getRenterEmail())
        .build();

    // Rental entity
    return Rental.builder()
        .id(dto.getRentalId())
        .car(car)
        .user(user)
        .pickUpLocation(dto.getPickUpLocation())
        .dropOffLocation(dto.getDropOffLocation())
        .startDate(dto.getStartDate())
        .endDate(dto.getEndDate())
        .build();
  }
}
