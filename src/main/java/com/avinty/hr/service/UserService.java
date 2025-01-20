package com.avinty.hr.service;

import com.avinty.hr.DTO.UserDTO;

import java.util.List;

public interface UserService {
  List<UserDTO> getAllUsers();

  UserDTO getUserById(final Long id);

  List<UserDTO> getUserByName(final String name);

  UserDTO addNewUser(UserDTO dto);

  UserDTO modifyUser(final Long id, UserDTO dto);

  void deleteUserById(final Long id);
}
