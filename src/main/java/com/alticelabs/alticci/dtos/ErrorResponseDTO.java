package com.alticelabs.alticci.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponseDTO {

  private String message;
}
