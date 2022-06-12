package com.alticelabs.alticci.services;

import com.alticelabs.alticci.repositories.Cache;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class AlticciServiceTest {

  @InjectMocks AlticciService service;
  @Mock Cache<Integer, Integer> cache;

  @ParameterizedTest
  @CsvSource({"0,0", "1,1", "2,1", "3,1", "4,2", "5,2", "6,3", "7,4", "8,5", "9,7", "10,9"})
  @DisplayName("Known results")
  void calculateAlticciShouldReturnExpectedValues(long input, long result) {

    when(cache.containsKey(any())).thenReturn(false);

    assertEquals(result, service.calculateAlticci(input));

    verify(cache).containsKey(input);
  }
}
