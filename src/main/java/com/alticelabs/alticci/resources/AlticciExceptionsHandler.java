package com.alticelabs.alticci.resources;

import com.alticelabs.alticci.dtos.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class AlticciExceptionsHandler {

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<ErrorResponseDTO> handleConstraintViolation(
      ConstraintViolationException exception) {

    ErrorResponseDTO errorDTO =
        ErrorResponseDTO.builder().message(exception.getMessage().split(": ")[1]).build();

    return ResponseEntity.badRequest().body(errorDTO);
  }

  @ExceptionHandler(StackOverflowError.class)
  public ResponseEntity<ErrorResponseDTO> handleStackOverflow(StackOverflowError exception) {

    ErrorResponseDTO errorDTO =
        ErrorResponseDTO.builder().message("1.000º value is not enough for you? I'm out").build();

    return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(errorDTO);
  }

  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  public ResponseEntity<ErrorResponseDTO> handleMethodArgumentTypeMismatch(
      MethodArgumentTypeMismatchException exception) {

    ErrorResponseDTO errorDTO =
        ErrorResponseDTO.builder()
            .message("Maximum acceptable index is 9.223.372.036.854.775.807")
            .build();

    return ResponseEntity.badRequest().body(errorDTO);
  }
}
