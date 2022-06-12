package com.alticelabs.alticci.resources;

import com.alticelabs.alticci.services.AlticciService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AlticciControllerImplTest {

  @Autowired MockMvc mockMvc;
  @MockBean AlticciService service;

  @Test
  @DisplayName("Get Alticci value")
  void findAlticciIndexShouldReturnTheAlticciIndex() throws Exception {

    when(service.calculateAlticci(1L)).thenReturn(1L);

    mockMvc
        .perform(get("/alticci/1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.index").value(1L))
        .andExpect(jsonPath("$.value").value(1L));

    verify(service).calculateAlticci(1L);
  }

  @Test
  @DisplayName("Negative index input")
  void findAlticciIndexShouldReturnABadRequestWhenInputIndexIsNotPositive() throws Exception {

    mockMvc
        .perform(get("/alticci/-1"))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.message").value("Input index must be 0 or higher"));
  }
}
