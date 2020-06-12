package com.sme.springcloud.common.builder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Unit tests of {@link LinkBuilder}.
 */
public class ListBuilderTest
{
    @Test
    public void testListBuilder() throws Exception
    {
        List<String> list = new ListBuilder<>("One", "Two")
                .add("Three")
                .build();

        assertEquals(Arrays.asList("One", "Two", "Three"), list);
    }
}
