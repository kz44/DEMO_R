package com.avinty.hr.service;

import com.avinty.hr.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarServiceImp implements CarService {

  private final CarRepository carRepository;

}
