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

  public RentalDTO toDTO(Rental entity) {
    return RentalDTO.builder()
        .rentalId(entity.getId())

        .carId(entity.getCar().getId())
        .carBrand(entity.getCar().getBrand())
        .carLicensePlate(entity.getCar().getLicensePlate())
        .carColor(entity.getCar().getColor())
        .carCategory(entity.getCar().getCategory())

        .renterId(entity.getUser().getId())
        .renterName(entity.getUser().getName())
        .renterPhoneNumber(entity.getUser().getPhoneNumber())
        .renterEmail(entity.getUser().getEmail())

        .pickUpLocation(entity.getPickUpLocation())
        .dropOffLocation(entity.getDropOffLocation())
        .startDate(entity.getStartDate())
        .endDate(entity.getEndDate())

        .build();
  }


  public Rental toEntity(RentalDTO dto) {

    Car car = Car.builder()
        .id(dto.getCarId())
        .brand(dto.getCarBrand())
        .licensePlate(dto.getCarLicensePlate())
        .color(dto.getCarColor())
        .category(dto.getCarCategory())
        .build();

    User user = User.builder()
        .id(dto.getRenterId())
        .name(dto.getRenterName())
        .phoneNumber(dto.getRenterPhoneNumber())
        .email(dto.getRenterEmail())
        .build();


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
