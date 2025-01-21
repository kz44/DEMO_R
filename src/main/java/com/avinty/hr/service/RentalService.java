package com.avinty.hr.service;

import com.avinty.hr.DTO.RentalDTO;

import java.util.List;

public interface RentalService {

  Long getTotalRentals();

  RentalDTO getRentalByUserId(final Long userId);

  List<RentalDTO> getRentalsByUserId(final Long userId);
}
