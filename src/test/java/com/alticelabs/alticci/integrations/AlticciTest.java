package com.alticelabs.alticci.integrations;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AlticciTest {

  @Autowired MockMvc mockMvc;

  @ParameterizedTest
  @CsvSource({"0,0", "1,1", "2,1", "3,1", "4,2", "5,2", "6,3", "7,4", "8,5", "9,7", "10,9"})
  void alticciShouldReturnTheEquivalentAlticciValue(long index, long value) throws Exception {

    mockMvc
        .perform(get("/alticci/" + index))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.index").value(index))
        .andExpect(jsonPath("$.value").value(value));
  }
}
