package com.avinty.hr.service;

import com.avinty.hr.DTO.RentalDTO;
import com.avinty.hr.exception.EntityNotFoundException;
import com.avinty.hr.mapper.CarMapper;
import com.avinty.hr.mapper.RentalMapper;
import com.avinty.hr.mapper.UserMapper;
import com.avinty.hr.model.Car;
import com.avinty.hr.model.Rental;
import com.avinty.hr.model.User;
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
  private final CarService carService;
  private final UserService userService;
  private final RentalMapper rentalMapper;
  private final CarMapper carMapper;
  private final UserMapper userMapper;

  /**
   * Retrieves the total number of rentals in the system.
   *
   * @return the total number of rentals.
   */
  @Override
  public Long getTotalRentals() {
    return rentalRepository.count();
  }


  /**
   * Retrieves the current rental for a user (if any) where the rental end date is after the current date.
   *
   * @param userId the ID of the user.
   * @return a {@link RentalDTO} representing the user's current rental.
   * @throws EntityNotFoundException if no current rental is found for the user.
   */
  @Override
  public RentalDTO getRentalByUserId(Long userId) {
    return rentalRepository.findByUserIdAndEndDateAfter(userId, LocalDateTime.now())
        .map(rentalMapper::toDTO)
        .orElseThrow(() -> new EntityNotFoundException("No current rental found for user " + userId));
  }


  /**
   * Checks whether a rental exists by the given user ID.
   *
   * @param userId the ID of the user.
   * @return true if a rental exists for the user, false otherwise.
   */
  boolean existRentalById(final Long userId) {
    return rentalRepository.existsById(userId);
  }


  /**
   * Retrieves all rentals for a specific user.
   *
   * @param userId the ID of the user.
   * @return a list of {@link RentalDTO} representing the user's rentals.
   * @throws EntityNotFoundException if no rentals are found for the user.
   */
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


  /**
   * Adds a new rental record to the system.
   *
   * @param rentalDTO the {@link RentalDTO} containing the rental details.
   * @return the newly created {@link RentalDTO}.
   */
  @Override
  public RentalDTO addNewRental(RentalDTO rentalDTO) {

    Car car = carMapper.toEntity(carService.getCarById(rentalDTO.getCarId()));
    User user = userMapper.toEntity(userService.getUserById(rentalDTO.getRenterId()));

    Rental newRental = Rental.builder()
        .car(car)
        .user(user)
        .pickUpLocation(rentalDTO.getPickUpLocation())
        .dropOffLocation(rentalDTO.getDropOffLocation())
        .startDate(rentalDTO.getStartDate())
        .endDate(rentalDTO.getEndDate())
        .build();

    Rental savedRental = rentalRepository.save(newRental);

    return rentalMapper.toDTO(savedRental);
  }
}
