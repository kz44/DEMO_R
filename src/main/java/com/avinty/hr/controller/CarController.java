package com.avinty.hr.controller;

import com.avinty.hr.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/API/V1")
public class CarController {

  private final CarService carService;


}
