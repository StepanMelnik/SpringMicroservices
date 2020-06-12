package com.sme.springcloud.common.model;

import java.lang.reflect.ParameterizedType;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

/**
 * Pojo tester based on <a href="https://github.com/OpenPojo/openpojo">openpojo</a> library.
 */
public abstract class APojoTest<T> extends Assertions
{
    @Test
    public void testPojo() throws Exception
    {
        Validator validator = ValidatorBuilder.create()
                .with(new GetterMustExistRule())
                .with(new SetterMustExistRule())
                .with(new SetterTester())
                .with(new GetterTester())
                .build();

        @SuppressWarnings("unchecked")
        Class<T> clazz = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];

        validator.validate(PojoClassFactory.getPojoClass(clazz));
    }
}
