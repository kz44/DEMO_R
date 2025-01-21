package com.avinty.hr.service;

import com.avinty.hr.DTO.RentalDTO;

public interface RentalService {

  Long getTotalRentals ();

  RentalDTO getRentalDetailsByUserId(final Long userId);
}
