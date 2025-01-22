package com.avinty.hr.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rentals")
public class Rental {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "car_id", nullable = false)
  private Car car;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @NotBlank(message = "Pick-up location cannot be blank")
  private String pickUpLocation;

  @NotBlank(message = "Drop-off location cannot be blank")
  private String dropOffLocation;

  @NotNull(message = "Start date cannot be null")
  private LocalDateTime startDate;

  @NotNull(message = "End date cannot be null")
  private LocalDateTime endDate;
}
