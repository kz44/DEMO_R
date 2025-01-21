package com.avinty.hr.controller;


import com.avinty.hr.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/API/V1/leases")
public class LeasesController {

  private final RentalService rentalService;
}
