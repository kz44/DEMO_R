package com.avinty.hr.mapper;

import com.avinty.hr.DTO.UserDTO;
import com.avinty.hr.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

  public UserDTO toDTO(User entity) {
    return UserDTO.builder()
        .id(entity.getId())
        .name(entity.getName())
        .phoneNumber(entity.getPhoneNumber())
        .email(entity.getEmail())
        .build();
  }


  public User toEntity(UserDTO dto) {
    return User.builder()
        .id(dto.getId())
        .name(dto.getName())
        .phoneNumber(dto.getPhoneNumber())
        .email(dto.getEmail())
        .build();
  }
}
