package com.avinty.hr.service;

import com.avinty.hr.DTO.UserDTO;
import com.avinty.hr.exception.EntityNotFoundException;
import com.avinty.hr.mapper.UserMapper;
import com.avinty.hr.model.User;
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
        .orElseThrow(() -> new EntityNotFoundException("User doesn't exist with the given id"));
  }


  @Override
  public List<UserDTO> getUserByName(String name) {
    List<UserDTO> users = userRepository.findByUserContainingIgnoreCase(name)
        .stream()
        .map(userMapper::toDTO)
        .toList();

    if (users.isEmpty()) {
      throw new EntityNotFoundException("There is no User with the given name.");
    }

    return users;
  }


  @Override
  public UserDTO addNewUser(UserDTO dto) {

    User user = userMapper.toEntity(dto);
    userRepository.save(user);

    return userMapper.toDTO(user);
  }


  @Override
  public UserDTO modifyUser(final Long id, final UserDTO dto) {
    User oldUser = userMapper.toEntity(getUserById(id));

    oldUser.setId(dto.getId());
    oldUser.setName(dto.getName());
    oldUser.setPhoneNumber(dto.getPhoneNumber());
    oldUser.setEmail(dto.getEmail());

    userRepository.save(oldUser);

    return userMapper.toDTO(oldUser);
  }


  @Override
  public void deleteUserById(Long id) {
    getUserById(id);
    userRepository.deleteById(id);
  }
}

