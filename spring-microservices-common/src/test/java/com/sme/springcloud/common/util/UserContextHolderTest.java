package com.sme.springcloud.common.util;

import static com.sme.springcloud.common.util.UserContextHolder.getContext;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sme.springcloud.common.builder.PojoGenericBuilder;
import com.sme.springcloud.common.model.UserContext;

/**
 * Unit tests of {@link UserContextHolder}.
 */
public class UserContextHolderTest
{
    @BeforeEach
    public void setUp() throws Exception
    {
        UserContextHolder.remove();
    }

    @AfterEach
    public void tearDown() throws Exception
    {
        UserContextHolder.remove();
    }

    @Test
    void testGetUserContext() throws Exception
    {
        assertEquals(new UserContext(), UserContextHolder.getContext());
    }

    @Test
    void testSetGetUserContext() throws Exception
    {
        UserContextHolder.setContext(new PojoGenericBuilder<>(UserContext::new)
                .with(UserContext::setAuthToken, "auth token")
                .with(UserContext::setCorrelationId, "correlation id")
                .with(UserContext::setUserId, "user id")
                .build());

        assertEquals(new PojoGenericBuilder<>(UserContext::new)
                .with(UserContext::setAuthToken, "auth token")
                .with(UserContext::setCorrelationId, "correlation id")
                .with(UserContext::setUserId, "user id")
                .build(), getContext());
    }
}
