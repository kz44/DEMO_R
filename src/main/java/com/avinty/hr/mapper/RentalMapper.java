package com.avinty.hr.mapper;

import com.avinty.hr.DTO.RentalDTO;
import com.avinty.hr.model.Car;
import com.avinty.hr.model.Rental;
import com.avinty.hr.model.User;
import com.avinty.hr.service.CarService;
import com.avinty.hr.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RentalMapper {

  private final CarService carService;
  private final UserService userService;
  private final CarMapper carMapper;
  private final UserMapper userMapper;

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

        // User details (renter)
        .renterId(entity.getUser().getId())

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
    Car car = carMapper.toEntity(carService.getCarById(dto.getCarId()));

    // User details (renter)
    User user = userMapper.toEntity(userService.getUserById(dto.getRenterId()));

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
