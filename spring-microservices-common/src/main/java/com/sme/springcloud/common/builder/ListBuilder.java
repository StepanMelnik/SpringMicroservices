package com.sme.springcloud.common.builder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * List builder.
 * 
 * @param T The type of elements in the list.
 */
public class ListBuilder<T>
{
    private final List<T> list;

    @SafeVarargs
    public ListBuilder(T... items)
    {
        list = new ArrayList<>();
        for (T obj : items)
        {
            list.add(obj);
        }
    }

    /**
     * Add a given object to the list.
     * 
     * @param obj The given object to add to the list;
     * @return Returns {@link ListBuilder} instance.
     */
    public ListBuilder<T> add(T obj)
    {
        list.add(obj);
        return this;
    }

    /**
     * Add a collection to the list.
     * 
     * @param items The collection to add to the list;
     * @return Returns {@link ListBuilder} instance.
     */
    public ListBuilder<T> addAll(Collection<? extends T> items)
    {
        list.addAll(items);
        return this;
    }

    /**
     * Add a stream to the list.
     * 
     * @param items The stream to add to the list;
     * @return Returns {@link ListBuilder} instance.
     */
    public ListBuilder<T> addAll(Stream<? extends T> items)
    {
        return addAll(items.collect(Collectors.toList()));
    }

    /**
     * Builds the {@link List}.
     *
     * @return Returns the {@link List}.
     */
    public List<T> build()
    {
        return list;
    }

    /**
     * Builds an immutable {@link List}.
     *
     * @return Returns the built (immutable) {@link List}.
     */
    public List<T> buildImmutable()
    {
        return Collections.unmodifiableList(list);
    }

    @Override
    public String toString()
    {
        return list.toString();
    }
}
