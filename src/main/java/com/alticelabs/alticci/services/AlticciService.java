package com.alticelabs.alticci.services;

import com.alticelabs.alticci.repositories.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlticciService {

  @Autowired private Cache<Long, Long> cache;

  public long calculateAlticci(final long index) {

    if (cache.containsKey(index)) {
      return cache.get(index);
    }

    if (index == 0L) {
      return 0L;
    }

    if (index == 1L || index == 2L) {
      return 1L;
    }

    long result = calculateAlticci(index - 3L) + calculateAlticci(index - 2L);
    cache.put(index, result);

    return result;
  }
}
