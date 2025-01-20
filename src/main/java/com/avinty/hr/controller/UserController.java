package com.avinty.hr.controller;

import com.avinty.hr.DTO.UserDTO;
import com.avinty.hr.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
