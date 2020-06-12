package com.sme.springcloud.common.builder;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Map builder.
 * 
 * @param <K> - key type
 * @param <V> - value type
 */
public class MapBuilder<K, V>
{
    private Map<K, V> map;

    public MapBuilder(Map<K, V> map)
    {
        this.map = new HashMap<>(Objects.requireNonNull(map));
    }

    public MapBuilder()
    {
        this(false);
    }

    public MapBuilder(boolean isOrdered)
    {
        map = isOrdered ? new LinkedHashMap<>() : new HashMap<>();
    }

    public MapBuilder(K key, V value)
    {
        this();
        map.put(key, value);
    }

    /**
     * Add new element.
     * 
     * @param key The key of map;
     * @param value The vaue of map;
     * @return Returns {@link MapBuilder}.
     */
    public MapBuilder<K, V> put(K key, V value)
    {
        map.put(key, value);
        return this;
    }

    /**
     * Puts all entries of given map into the map being built.
     *
     * @param map whose entries to put to built map;
     * @return Returns {@link MapBuilder}.
     */
    public MapBuilder<K, V> putAll(Map<? extends K, ? extends V> map)
    {
        this.map.putAll(map);
        return this;
    }

    /**
     * Builds the {@link Map}.
     *
     * @return Returns the built {@link Map}.
     */
    public Map<K, V> build()
    {
        return map;
    }

    /**
     * Builds the immutable {@link Map}.
     *
     * @return Returns the built immutable {@link Map}.
     */
    public Map<K, V> buildImmutable()
    {
        return Collections.unmodifiableMap(map);
    }

    @Override
    public String toString()
    {
        return map.toString();
    }
}
