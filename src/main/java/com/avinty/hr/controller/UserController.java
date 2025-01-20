package com.avinty.hr.controller;

import com.avinty.hr.DTO.CarDTO;
import com.avinty.hr.DTO.UserDTO;
import com.avinty.hr.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/API/V1/users")
public class UserController {

  private final UserService userService;

  /**
   * Retrieves all users.
   *
   * @return a list of {@link UserDTO} representing all users.
   */
  @GetMapping()
  public ResponseEntity<List<UserDTO>> getUsers() {
    return ResponseEntity.ok(userService.getAllUsers());
  }


  /**
   * Retrieves a user by ID.
   *
   * @param id the ID of the user.
   * @return {@link UserDTO} representing the user.
   */
  @GetMapping("/{id}")
  public ResponseEntity<UserDTO> getCarById(@PathVariable final Long id) {
    return ResponseEntity.ok(userService.getUserById(id));
  }

  /**
   * Retrieves users by their name.
   *
   * @param name the name to search for.
   * @return a list of {@link UserDTO} representing users with the given name.
   */
  @GetMapping("/name")
  public ResponseEntity<List<UserDTO>> getCarsByLicensePlate(@RequestParam final String name) {
    return ResponseEntity.ok(userService.getUserByName(name));
  }

  /**
   * Adds a new user.
   *
   * @param newUser the user to add.
   * @return {@link UserDTO} representing the added user.
   */
  @PostMapping()
  public ResponseEntity<UserDTO> addNewUser(@Valid @RequestBody UserDTO newUser) {
    return ResponseEntity.ok(userService.addNewUser(newUser));
  }


  /**
   * Updates an existing user by ID.
   *
   * @param id  the ID of the user to update.
   * @param dto the new user details.
   * @return {@link UserDTO} representing the updated user.
   */
  @PutMapping("/{id}")
  public ResponseEntity<UserDTO> updateUserById(@PathVariable final Long id,
                                                @Valid @RequestBody UserDTO dto) {
    return ResponseEntity.ok(userService.modifyUser(id, dto));
  }


  /**
   * Deletes a user by ID.
   *
   * @param id the ID of the user to delete.
   * @return HTTP status with no content.
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUserById(@PathVariable final Long id) {
    userService.deleteUserById(id);
    return ResponseEntity.noContent().build();
  }
}
