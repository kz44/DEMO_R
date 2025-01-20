package com.avinty.hr.service;

import com.avinty.hr.DTO.CarDTO;

import java.util.List;

public interface CarService {

  List<CarDTO> getAllCars();

  CarDTO getCarById(final Long id);

  List<CarDTO> getCarByLicensePlate(final String licensePlate);

  boolean existCarByLicensePlate(final String licensePlate);

  CarDTO addNewCar(CarDTO dto);

}
