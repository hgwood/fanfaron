package com.github.hgwood.fanfaron.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DynamicObject<T> implements Map<String, T> {
    private final Map<String, T> delegate;

    protected DynamicObject(Map<String, T> delegate) {
        this.delegate = delegate;
    }

    protected DynamicObject() {
        this(new HashMap<String, T>());
    }

    @Override public int size() {
        return delegate.size();
    }

    @Override public boolean isEmpty() {
        return delegate.isEmpty();
    }

    @Override public boolean containsKey(Object key) {
        return delegate.containsKey(key);
    }

    @Override public boolean containsValue(Object value) {
        return delegate.containsValue(value);
    }

    @Override public T get(Object key) {
        return delegate.get(key);
    }

    @Override public T put(String key, T value) {
        return delegate.put(key, value);
    }

    @Override public T remove(Object key) {
        return delegate.remove(key);
    }

    @Override public void putAll(Map<? extends String, ? extends T> m) {
        delegate.putAll(m);
    }

    @Override public void clear() {
        delegate.clear();
    }

    @Override public Set<String> keySet() {
        return delegate.keySet();
    }

    @Override public Collection<T> values() {
        return delegate.values();
    }

    @Override public Set<Entry<String, T>> entrySet() {
        return delegate.entrySet();
    }

    @Override public boolean equals(Object obj) {
        return delegate.equals(obj);
    }

    @Override public int hashCode() {
        return delegate.hashCode();
    }
}
