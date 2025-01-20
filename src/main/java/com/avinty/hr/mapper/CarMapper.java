package com.avinty.hr.mapper;

import com.avinty.hr.DTO.CarDTO;
import com.avinty.hr.model.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CarMapper {

  public CarDTO toDTO(Car entity) {
    return CarDTO.builder()
        .id(entity.getId())
        .brand(entity.getBrand())
        .licensePlate(entity.getLicensePlate())
        .color(entity.getColor())
        .category(entity.getCategory())
        .build();
  }


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
