package com.avinty.hr.service;

import com.avinty.hr.DTO.UserDTO;
import com.avinty.hr.exception.CarNotFoundException;
import com.avinty.hr.mapper.UserMapper;
import com.avinty.hr.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;

  @Override
  public List<UserDTO> getAllUsers() {
    return userRepository.findAll()
        .stream()
        .map(userMapper::toDTO)
        .collect(Collectors.toList());
  }

  public UserDTO getUserById(final Long id) {
    return userRepository.findById(id)
        .map(userMapper::toDTO)
        .orElseThrow(() -> new CarNotFoundException("User doesn't exist with the given id"));
  }
}
