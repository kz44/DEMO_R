package com.avinty.hr.controller;

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

  @GetMapping()
  public ResponseEntity<List<UserDTO>> getUsers() {
    return ResponseEntity.ok(userService.getAllUsers());
  }


  @GetMapping("/{id}")
  public ResponseEntity<UserDTO> getCarById(@PathVariable final Long id) {
    return ResponseEntity.ok(userService.getUserById(id));
  }

  @GetMapping("/name")
  public ResponseEntity<List<UserDTO>> getCarsByLicensePlate(@RequestParam final String name) {
    return ResponseEntity.ok(userService.getUserByName(name));
  }

  @PostMapping()
  public ResponseEntity<UserDTO> addNewUser(@Valid @RequestBody UserDTO newUser) {
    return ResponseEntity.ok(userService.addNewUser(newUser));
  }
}
