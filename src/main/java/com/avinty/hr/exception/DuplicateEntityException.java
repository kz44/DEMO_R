package com.avinty.hr.exception;

public class DuplicateEntityException extends RuntimeException {
  public DuplicateEntityException(String message) {
    super(message);
  }
}
