package com.avinty.hr.model;

import com.avinty.hr.enums.Category;
import jakarta.persistence.*;
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

  private String brand;

  private String licensePlate;

  private String color;

  @Enumerated(EnumType.STRING)
  private Category category;
}
