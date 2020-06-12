package com.sme.springcloud.common.builder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * Unit tests of {@link MapBuilder}.
 */
public class MapBuilderTest
{
    @Test
    public void testMapBuilder() throws Exception
    {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        Map<Integer, String> map1 = new MapBuilder<Integer, String>(false)
                .put(1, "One")
                .put(2, "Two")
                .put(3, "Three")
                .build();

        assertEquals(map, map1);
    }
}
