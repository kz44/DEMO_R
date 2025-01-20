package com.avinty.hr.service;

import com.avinty.hr.DTO.CarDTO;
import com.avinty.hr.DTO.UserDTO;

import java.util.List;

public interface UserService {
  List<UserDTO> getAllUsers();

  UserDTO getUserById(final Long id);

  List<UserDTO> getUserByName(final String name);
}
