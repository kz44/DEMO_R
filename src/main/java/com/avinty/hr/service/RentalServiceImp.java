package com.avinty.hr.service;

import com.avinty.hr.DTO.RentalDTO;
import com.avinty.hr.exception.EntityNotFoundException;
import com.avinty.hr.mapper.RentalMapper;
import com.avinty.hr.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
  public RentalDTO getRentalByUserId(Long userId) {
    return rentalRepository.findByUserIdAndEndDateAfter(userId, LocalDateTime.now())
        .map(rentalMapper::toDTO)
        .orElseThrow(() -> new EntityNotFoundException("No current rental found for user " + userId));
  }

  boolean existRentalById(final Long userId) {
    return rentalRepository.existsById(userId);
  }
  @Override
  public List<RentalDTO> getRentalsByUserId(Long userId) {

    if (!existRentalById(userId)) {
      throw new EntityNotFoundException("No current rental found for user " + userId);
    }

    return rentalRepository.findAllRentalByUserId(userId)
        .stream()
        .map(rentalMapper::toDTO)
        .collect(Collectors.toList());
  }
}
