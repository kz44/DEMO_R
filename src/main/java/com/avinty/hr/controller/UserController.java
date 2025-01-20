package com.avinty.hr.controller;

import com.avinty.hr.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/API/V1/users")
public class UserController {

  private final UserService userService;
}
