package com.avinty.hr.service;

import com.avinty.hr.DTO.RentalDTO;

import java.util.List;

public interface RentalService {

  Long getTotalRentals();

  RentalDTO getRentalByUserId(final Long userId);

  boolean existRentalByUserId(final Long userId);

  List<RentalDTO> getAllRentalsByUserId(final Long userId);

  RentalDTO addNewRental(RentalDTO rentalDTO);
}
