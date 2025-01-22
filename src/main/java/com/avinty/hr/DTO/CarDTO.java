package com.avinty.hr.DTO;

import com.avinty.hr.enums.Category;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDTO {

  private Long id;

  @NotBlank(message = "Brand must not be null")
  @Size(min = 2, max = 50, message = "Brand must be between 2 and 50 characters")
  private String brand;

  @NotNull(message = "License plate must not be null")
  private String licensePlate;

  @NotBlank(message = "Car color cannot be blank")
  private String color;

  @NotNull(message = "Category must not be null")
  @Enumerated(EnumType.STRING)
  private Category category;

}
