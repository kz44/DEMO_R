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

  /**
   * Retrieves all users, sorted by brand in ascending order.
   *
   * @return List of {@link UserDTO} representing all users.
   */
  @Override
  public List<UserDTO> getAllUsers() {
    return userRepository.findAll()
        .stream()
        .map(userMapper::toDTO)
        .collect(Collectors.toList());
  }

  /**
   * Retrieves a user by its ID.
   *
   * @param id the ID of the user to retrieve.
   * @return {@link UserDTO} representing the user.
   * @throws EntityNotFoundException if the user with the given ID is not found.
   */
  public UserDTO getUserById(final Long id) {
    return userRepository.findById(id)
        .map(userMapper::toDTO)
        .orElseThrow(() -> new EntityNotFoundException("User doesn't exist with the given id"));
  }


  /**
   * Retrieves a list of users by their name.
   *
   * @param name the name to search for.
   * @return List of {@link UserDTO} representing users matching the name.
   * @throws EntityNotFoundException if no users are found with the given name.
   */
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


  /**
   * Adds a new User to the repository.
   *
   * @param dto the user information to add.
   * @return {@link UserDTO} representing the added user.
   */

  @Override
  public UserDTO addNewUser(UserDTO dto) {

    User user = userMapper.toEntity(dto);
    userRepository.save(user);

    return userMapper.toDTO(user);
  }


  /**
   * Modifies an existing user's details.
   *
   * @param id  the ID of the user to modify.
   * @param dto the new user details.
   * @return {@link UserDTO} representing the modified user.
   */
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


  /**
   * Deletes an user by ID.
   *
   * @param id the ID of the user to delete.
   */
  @Override
  public void deleteUserById(Long id) {
    getUserById(id);
    userRepository.deleteById(id);
  }
}

