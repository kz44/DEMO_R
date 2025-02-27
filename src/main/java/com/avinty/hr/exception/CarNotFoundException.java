package com.avinty.hr.exception;

public class CarNotFoundException extends RuntimeException {
  public CarNotFoundException(String message) {
    super(message);
  }
}
