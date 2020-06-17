package com.sme.springcloud.common.filter;

import static com.sme.springcloud.common.util.UserContextHolder.getContext;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.sme.springcloud.common.builder.PojoGenericBuilder;
import com.sme.springcloud.common.model.UserContext;

/**
 * Unit tests of {@link UserContextFilter}.
 */
public class UserContextFilterTest
{
    private MockHttpServletRequest servletRequest;
    private MockHttpServletResponse servletResponse;
    private MockFilterChain filterChain;

    private UserContextFilter userContextFilter;

    @BeforeEach
    public void setUp() throws Exception
    {
        servletRequest = new MockHttpServletRequest();
        servletResponse = new MockHttpServletResponse();
        filterChain = new MockFilterChain();

        userContextFilter = new UserContextFilter();
    }

    @Test
    void testDoFilter() throws Exception
    {
        final String authToken = "auth token";
        final String correlationId = "correlation id";
        final String userId = "user id";

        servletRequest.addHeader(UserContext.AUTH_TOKEN, authToken);
        servletRequest.addHeader(UserContext.CORRELATION_ID, correlationId);
        servletRequest.addHeader(UserContext.USER_ID, userId);

        userContextFilter.doFilter(servletRequest, servletResponse, filterChain);

        assertEquals(new PojoGenericBuilder<>(UserContext::new)
                .with(UserContext::setAuthToken, authToken)
                .with(UserContext::setCorrelationId, correlationId)
                .with(UserContext::setUserId, userId)
                .build(), getContext());
    }
}
