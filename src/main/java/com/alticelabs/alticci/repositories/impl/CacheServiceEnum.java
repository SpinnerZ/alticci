package com.alticelabs.alticci.repositories.impl;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public enum CacheServiceEnum {
  INSTANCE;

  private final ConcurrentHashMap<Long, Long> cache;

  private CacheServiceEnum() {
    this.cache = new ConcurrentHashMap<>();
  }

  public ConcurrentMap<Long, Long> cache() {
    return this.cache;
  }
}
