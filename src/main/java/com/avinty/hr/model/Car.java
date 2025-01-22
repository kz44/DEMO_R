package com.avinty.hr.model;

import com.avinty.hr.enums.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cars")
public class Car {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull(message = "Brand must not be null")
  @Size(min = 2, max = 50, message = "Brand must be between 2 and 50 characters")
  private String brand;

  @NotNull(message = "License plate must not be null")
  private String licensePlate;

  @NotNull(message = "Color most not be null")
  private String color;

  @NotNull(message = "Category must not be null")
  @Enumerated(EnumType.STRING)
  private Category category;
}
