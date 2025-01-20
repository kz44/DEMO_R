package com.avinty.hr.service;

import com.avinty.hr.DTO.CarDTO;
import com.avinty.hr.exception.CarNotFoundException;
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


  public CarDTO getCarById(final Long id) {
    return carRepository.findById(id)
        .map(carMapper::toDTO)
        .orElseThrow(() -> new CarNotFoundException("Car doesn't exist with the given id"));
  }

  @Override
  public List<CarDTO> getCarByLicensePlate(String licensePlate) {

    List<CarDTO> cars = carRepository.findByLicensePlateContainingIgnoreCase(licensePlate)
        .stream()
        .map(carMapper::toDTO)
        .toList();

    if (cars.isEmpty()) {
      throw new CarNotFoundException("There is no car with the given license plate.");
    }

    return cars;
  }

}
