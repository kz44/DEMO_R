package com.avinty.hr.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

  private long id;

  @NonNull
  private String name;

  @NonNull
  private String phoneNumber;

  @NonNull
  private String email;
}
