package com.avinty.hr.repository;

import com.avinty.hr.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface RentalRepository extends JpaRepository<Rental, Long> {



  @Query("SELECT r FROM Rental r WHERE r.user.id = :userId AND r.endDate > :endDate ORDER BY r.endDate ASC LIMIT 1")
  Optional<Rental> findByUserIdAndEndDateAfter(@Param("userId") Long userId, @Param("endDate") LocalDateTime endDate);


  @Query("SELECT r FROM Rental r WHERE r.user.id = :userId ORDER BY r.endDate ASC")
  List<Rental> findAllRentalByUserId(@Param("userId") Long userId);
}
