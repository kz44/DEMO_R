package com.avinty.hr.repository;

import com.avinty.hr.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

  @Query("SELECT u FROM User u " +
      "WHERE LOWER(u.name) LIKE LOWER(CONCAT('%', :name, '%')) " +
      "ORDER BY u.name ASC")
  List<User> findByUserContainingIgnoreCase(String name);
}
