package com.avinty.hr.DTO;

import com.avinty.hr.enums.Category;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDTO {

  private Long id;

  @NonNull
  private String brand;

  @NonNull
  private String licensePlate;

  @NonNull
  private String color;

  @NonNull
  @Enumerated(EnumType.STRING)
  private Category category;

}
