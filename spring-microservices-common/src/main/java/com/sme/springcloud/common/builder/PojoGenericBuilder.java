package com.sme.springcloud.common.builder;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 * Generic builder of pojo.
 */
public class PojoGenericBuilder<T>
{
    private final T pojo;

    public PojoGenericBuilder(Supplier<T> supplier)
    {
        this.pojo = supplier.get();
    }

    /**
     * Create builder.
     * 
     * @param <T> The type of POJO;
     * @param supplier The supplier of POJO;
     * @return Returns POJO builder.
     */
    public static <T> PojoGenericBuilder<T> of(Supplier<T> supplier)
    {
        return new PojoGenericBuilder<>(supplier);
    }

    /**
     * Sets the single parameter of POJO.
     * 
     * @param <V> The value of setter;
     * @param consumer BiCosumer represents Settter method;
     * @param value The value of Setter;
     * @return Returns POJO builder.
     */
    public <V> PojoGenericBuilder<T> with(BiConsumer<T, V> consumer, V value)
    {
        consumer.accept(pojo, value);
        return this;
    }

    /**
     * Build POJO instance.
     * 
     * @return Returns instance.
     */
    public T build()
    {
        return pojo;
    }
}
