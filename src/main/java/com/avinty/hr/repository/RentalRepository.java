package com.avinty.hr.repository;

import com.avinty.hr.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface RentalRepository extends JpaRepository<Rental, Long> {


  /**
   * Finds the next rental for a specific user where the rental end date is after the given end date.
   *
   * @param userId  the ID of the user.
   * @param endDate the end date to compare against.
   * @return an {@link Optional} containing the next {@link Rental} if found, or empty if not.
   */
  @Query("SELECT r FROM Rental r WHERE r.user.id = :userId AND r.endDate > :endDate ORDER BY r.endDate ASC LIMIT 1")
  Optional<Rental> findByUserIdAndEndDateAfter(@Param("userId") Long userId, @Param("endDate") LocalDateTime endDate);


  /**
   * Finds all rentals for a specific user, ordered by the rental end date.
   *
   * @param userId the ID of the user.
   * @return a list of {@link Rental} entities associated with the given user, ordered by end date.
   */
  @Query("SELECT r FROM Rental r WHERE r.user.id = :userId ORDER BY r.endDate ASC")
  List<Rental> findAllRentalByUserId(@Param("userId") Long userId);


}
