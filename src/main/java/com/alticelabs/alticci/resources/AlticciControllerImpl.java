package com.alticelabs.alticci.resources;

import com.alticelabs.alticci.dtos.AlticciResponseDTO;
import com.alticelabs.alticci.services.AlticciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.PositiveOrZero;

@RestController
@RequestMapping(value = "/alticci")
@Validated
class AlticciControllerImpl implements AlticciController {

  @Autowired private AlticciService service;

  @Override
  @GetMapping("/{index}")
  public ResponseEntity<AlticciResponseDTO> findAlticciIndex(
      @PathVariable @PositiveOrZero(message = "Input index must be 0 or higher") Long index) {

    long value = service.calculateAlticci(index);

    return ResponseEntity.ok(AlticciResponseDTO.builder().index(index).value(value).build());
  }
}
