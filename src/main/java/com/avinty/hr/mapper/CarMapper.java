package com.avinty.hr.mapper;

import com.avinty.hr.DTO.CarDTO;
import com.avinty.hr.model.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CarMapper {

  /**
   * Converts a {@link Car} entity to a {@link CarDTO}.
   *
   * @param entity the {@link Car} entity to convert.
   * @return the corresponding {@link CarDTO}.
   */
  public CarDTO toDTO(Car entity) {
    return CarDTO.builder()
        .id(entity.getId())
        .brand(entity.getBrand())
        .licensePlate(entity.getLicensePlate())
        .color(entity.getColor())
        .category(entity.getCategory())
        .build();
  }


  /**
   * Converts a {@link CarDTO} to a {@link Car} entity.
   *
   * @param dto the {@link CarDTO} to convert.
   * @return the corresponding {@link Car} entity.
   */
  public Car toEntity(CarDTO dto) {
    return Car.builder()
        .id(dto.getId())
        .brand(dto.getBrand())
        .licensePlate(dto.getLicensePlate())
        .color(dto.getColor())
        .category(dto.getCategory())
        .build();
  }
}
