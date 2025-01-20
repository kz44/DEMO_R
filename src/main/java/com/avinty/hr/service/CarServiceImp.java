package com.avinty.hr.service;

import com.avinty.hr.DTO.CarDTO;
import com.avinty.hr.exception.EntityNotFoundException;
import com.avinty.hr.mapper.CarMapper;
import com.avinty.hr.model.Car;
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

  /**
   * Retrieves all cars, sorted by brand in ascending order.
   *
   * @return List of {@link CarDTO} representing all cars.
   */
  @Override
  public List<CarDTO> getAllCars() {
    return carRepository.findALlCarsSortedByBrandASC()
        .stream()
        .map(carMapper::toDTO)
        .collect(Collectors.toList());
  }

  /**
   * Retrieves a car by its ID.
   *
   * @param id the ID of the car to retrieve.
   * @return {@link CarDTO} representing the car.
   * @throws EntityNotFoundException if the car with the given ID is not found.
   */
  public CarDTO getCarById(final Long id) {
    return carRepository.findById(id)
        .map(carMapper::toDTO)
        .orElseThrow(() -> new EntityNotFoundException("Car doesn't exist with the given id"));
  }

  /**
   * Retrieves a list of cars by their license plate.
   *
   * @param licensePlate the license plate to search for.
   * @return List of {@link CarDTO} representing cars matching the license plate.
   * @throws EntityNotFoundException if no cars are found with the given license plate.
   */
  @Override
  public List<CarDTO> getCarByLicensePlate(String licensePlate) {

    List<CarDTO> cars = carRepository.findByLicensePlateContainingIgnoreCase(licensePlate)
        .stream()
        .map(carMapper::toDTO)
        .toList();

    if (cars.isEmpty()) {
      throw new EntityNotFoundException("There is no car with the given license plate.");
    }

    return cars;
  }


  /**
   * Checks if a car exists with the given license plate.
   *
   * @param licensePlate the license plate to check.
   * @return true if the car exists, false otherwise.
   */
  @Override
  public boolean existCarByLicensePlate(final String licensePlate) {
    return carRepository.existsCarByLicensePlateIgnoreCase(licensePlate);
  }


  /**
   * Adds a new car to the repository.
   *
   * @param dto the car information to add.
   * @return {@link CarDTO} representing the added car.
   * @throws IllegalArgumentException if a car with the same license plate already exists.
   */
  @Override
  public CarDTO addNewCar(CarDTO dto) {

    if (existCarByLicensePlate(dto.getLicensePlate())) {
      throw new IllegalArgumentException("Car with the given license plate already exist");
    } else {
      Car car = carMapper.toEntity(dto);
      car = carRepository.save(car);
      return carMapper.toDTO(car);
      // return carMapper.toDTO(carRepository.save(carMapper.toEntity(dto)));
    }
  }


  /**
   * Modifies an existing car's details.
   *
   * @param id  the ID of the car to modify.
   * @param dto the new car details.
   * @return {@link CarDTO} representing the modified car.
   */
  @Override
  public CarDTO modifyCar(final Long id, final CarDTO dto) {
    Car oldCar = carMapper.toEntity(getCarById(id));

    oldCar.setBrand(dto.getBrand());
    oldCar.setLicensePlate(dto.getLicensePlate());
    oldCar.setColor(dto.getColor());
    oldCar.setCategory(dto.getCategory());

    carRepository.save(oldCar);

    return carMapper.toDTO(oldCar);
  }


  /**
   * Deletes a car by its ID.
   *
   * @param id the ID of the car to delete.
   */
  @Override
  public void deleteCarById(Long id) {
    getCarById(id);
    carRepository.deleteById(id);
  }
}
