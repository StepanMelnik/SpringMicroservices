package com.sme.springcloud.gateway.filter;

import static com.netflix.zuul.context.RequestContext.getCurrentContext;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.sme.springcloud.common.model.UserContext;

/**
 * Unit tests of {@link ZuulResponseFilter}.
 */
public class ZuulResponseFilterTest
{
    private ZuulResponseFilter zuulResponseFilter;
    private MockHttpServletResponse response;

    @BeforeEach
    public void setUp()
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader(UserContext.CORRELATION_ID, "12345");
        getCurrentContext().setRequest(request);

        response = new MockHttpServletResponse();
        getCurrentContext().setResponse(response);

        zuulResponseFilter = new ZuulResponseFilter(new ZuulFilterHelper());
    }

    @Test
    void testRun() throws Exception
    {
        zuulResponseFilter.run();
        assertEquals("12345", response.getHeader(UserContext.CORRELATION_ID), "Expects created correlation-id response header");
    }
}
