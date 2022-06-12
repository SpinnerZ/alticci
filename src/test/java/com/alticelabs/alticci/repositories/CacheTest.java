package com.alticelabs.alticci.repositories;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class CacheTest {

  @Autowired Cache<Long, Long> cache;

  long key = 1L;
  long value = 12L;

  @Test
  @DisplayName("Put when value already exists")
  void putShouldUpdateValuesWhenValuesAlreadyExists() {

    cache.put(key, value + 1L);
    cache.put(key, value);

    assertEquals(value, cache.get(key));
  }

  @Test
  @DisplayName("Get when value does not exists")
  void getShouldReturnNullWhenValueDoesNotExists() {

    assertNull(cache.get(-1L));
  }

  @Test
  @DisplayName("Get when value exists")
  void getShouldReturnTheValueWhenValueExists() {

    cache.put(key, value);

    assertEquals(value, cache.get(key));
  }
}
