package com.alticelabs.alticci.repositories;

public interface Cache<K, V> {

  void put(K id, V entity);

  V get(Object key);

  boolean containsValue(Object value);

  boolean containsKey(Object value);
}
