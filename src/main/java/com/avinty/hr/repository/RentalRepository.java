package com.avinty.hr.repository;

import com.avinty.hr.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface RentalRepository extends JpaRepository<Rental, Long> {



  Optional<Rental> findByUserIdAndEndDateAfter(Long userId, LocalDateTime endDate);
}
