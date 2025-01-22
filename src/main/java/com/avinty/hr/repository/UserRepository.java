package com.avinty.hr.repository;

import com.avinty.hr.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

  /**
   * Finds users whose name contains the given string, case-insensitive, ordered by brand in ascending order.
   *
   * @param name the part of the name to search for.
   * @return a list of matching users.
   */
  @Query("SELECT u FROM User u " +
      "WHERE LOWER(u.name) LIKE LOWER(CONCAT('%', :name, '%')) " +
      "ORDER BY u.name ASC")
  List<User> findByUserContainingIgnoreCase(String name);


  /**
   * Checks if user with the given phone number exists.
   *
   * @param phoneNumber the phone number to check.
   * @return true if user exists, false otherwise.
   */
  boolean existsUserByPhoneNumber(String phoneNumber);
}
