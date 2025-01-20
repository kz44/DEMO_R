package com.avinty.hr.model;

import jakarta.persistence.*;
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
  @JoinColumn(name = "renter_id", nullable = false)
  private Renter renter;

  private String pickUpLocation;

  private String dropOffLocation;

  private LocalDateTime startDate;

  private LocalDateTime endDate;
}
