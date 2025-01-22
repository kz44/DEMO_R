package com.avinty.hr.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

  private long id;

  @NotBlank(message = "Name cannot be blank")
  @Size(min = 2, max = 70, message = "Name must be between 2 and 70 characters")
  private String name;

  @NotBlank(message = "Phone number cannot be blank")
  @Pattern(regexp = "^[+]?[0-9]{10,15}$", message = "Phone number must be valid")
  private String phoneNumber;

  @NotBlank(message = "Email cannot be blank")
  @Email(message = "Email must be valid")
  private String email;
}
