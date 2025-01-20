package com.avinty.hr.service;

import com.avinty.hr.DTO.CarDTO;
import com.avinty.hr.mapper.CarMapper;
import com.avinty.hr.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarServiceImp implements CarService {

  private final CarRepository carRepository;
  private final CarMapper carMapper;

  @Override
  public List<CarDTO> getAllCars() {
    return carRepository.findALlCarsSortedByBrandASC()
        .stream()
        .map(carMapper::toDTO)
        .collect(Collectors.toList());
  }
}
