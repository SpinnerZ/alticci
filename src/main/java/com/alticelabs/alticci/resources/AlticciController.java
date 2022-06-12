package com.alticelabs.alticci.resources;

import com.alticelabs.alticci.dtos.AlticciResponseDTO;
import com.alticelabs.alticci.dtos.ErrorResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import javax.validation.constraints.PositiveOrZero;

@Tag(name = "Alticci API", description = "Returns a value from Alticci sequence")
public interface AlticciController {

  @Operation(
      description = "Finds the Alticci sequence value for the given index",
      responses = {
        @ApiResponse(responseCode = "200", description = "Found the value"),
        @ApiResponse(
            responseCode = "400",
            description = "The index is invalid",
            content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
        @ApiResponse(
            responseCode = "418",
            description = "Cannot find value. StackOverflow",
            content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))
      })
  ResponseEntity<AlticciResponseDTO> findAlticciIndex(
      @Parameter(description = "Desired Alticci sequence index")
          @PositiveOrZero(message = "Input index must be 0 or higher")
          Long index);
}
