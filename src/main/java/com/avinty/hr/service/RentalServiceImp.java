package com.avinty.hr.service;

import com.avinty.hr.DTO.RentalDTO;
import com.avinty.hr.exception.EntityNotFoundException;
import com.avinty.hr.mapper.RentalMapper;
import com.avinty.hr.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RentalServiceImp implements RentalService {

  private final RentalRepository rentalRepository;
  private final RentalMapper rentalMapper;

  @Override
  public Long getTotalRentals() {
    return rentalRepository.count();
  }

  @Override
  public RentalDTO getRentalDetailsByUserId(Long userId) {
    return rentalRepository.findByUserIdAndEndDateAfter(userId, LocalDateTime.now())
        .map(rentalMapper::toDTO)
        .orElseThrow(() -> new EntityNotFoundException("No current rental found for user " + userId));
  }
}
