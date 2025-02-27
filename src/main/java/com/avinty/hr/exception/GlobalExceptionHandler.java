package com.avinty.hr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * Global exception handler class that handles different exceptions in the application.
 * <p>
 * The {@link ControllerAdvice} annotation allows providing a central solution for exceptions handled across all controllers.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(CarNotFoundException.class)
  public ResponseEntity<String> handleCarNotFoundException(CarNotFoundException ex, WebRequest request) {
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(ex.getMessage());
  }

  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(ex.getMessage());
  }

  @ExceptionHandler(RentalNotFoundException.class)
  public ResponseEntity<String> handleRentalNotFoundException(RentalNotFoundException ex, WebRequest request) {
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(ex.getMessage());
  }


  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(ex.getMessage());
  }


  @ExceptionHandler(DuplicateEntityException.class)
  public ResponseEntity<String> handleDuplicateEntityException(DuplicateEntityException ex, WebRequest request) {
    return ResponseEntity.status(HttpStatus.CONFLICT)
        .body(ex.getMessage());
  }
}
