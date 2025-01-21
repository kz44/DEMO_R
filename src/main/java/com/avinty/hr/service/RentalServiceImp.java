package com.avinty.hr.service;

import com.avinty.hr.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RentalServiceImp implements RentalService{

  private final RentalRepository rentalRepository;
}
