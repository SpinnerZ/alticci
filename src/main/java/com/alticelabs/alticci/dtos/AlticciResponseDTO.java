package com.alticelabs.alticci.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlticciResponseDTO {

  private long index;
  private long value;
}
