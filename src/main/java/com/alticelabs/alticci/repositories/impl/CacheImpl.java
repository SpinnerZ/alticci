package com.alticelabs.alticci.repositories.impl;

import com.alticelabs.alticci.repositories.Cache;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentMap;

@Component
public class CacheImpl implements Cache<Long, Long> {

  private static final ConcurrentMap<Long, Long> CACHE = CacheServiceEnum.INSTANCE.cache();

  @Override
  public Long get(Object key) {
    return CACHE.get(key);
  }

  @Override
  public void put(final Long id, final Long entity) {
    CACHE.put(id, entity);
  }

  @Override
  public boolean containsValue(Object value) {
    return CACHE.containsValue(value);
  }

  @Override
  public boolean containsKey(Object key) {
    return this.get(key) != null;
  }
}
