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


  /**
   * Checks if the car is rented within the given date range.
   * <p>
   * This method checks if the car is already rented during the specified start and end dates.
   * It returns true if the rental period overlaps with the given dates.
   * </p>
   *
   * @param carId     the ID of the car to check.
   * @param startDate the start date of the rental period.
   * @param endDate   the end date of the rental period.
   * @return {@code true} if the car is rented during the given period, {@code false} otherwise.
   */

  @Query("SELECT COUNT(r) > 0 FROM Rental r WHERE r.car.id = :carId AND " +
      "(:startDate BETWEEN r.startDate AND r.endDate OR " +
      ":endDate BETWEEN r.startDate AND r.endDate OR " +
      "r.startDate BETWEEN :startDate AND :endDate)")
  boolean existsByCarIdAndDateRange(@Param("carId") Long carId,
                                    @Param("startDate") LocalDateTime startDate,
                                    @Param("endDate") LocalDateTime endDate);
}
