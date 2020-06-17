package com.sme.springcloud.gateway.filter;

import static com.netflix.zuul.context.RequestContext.getCurrentContext;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;

import com.sme.springcloud.common.model.UserContext;

/**
 * Unit tests of {@link ZuulTrackingFilter}.
 */
public class ZuulTrackingFilterTest
{
    private ZuulTrackingFilter zuulTrackingFilter;
    private MockHttpServletRequest request;

    @BeforeEach
    public void setUp()
    {
        request = new MockHttpServletRequest();
        getCurrentContext().setRequest(request);

        zuulTrackingFilter = new ZuulTrackingFilter(new ZuulFilterHelper());
    }

    @Test
    void testRun() throws Exception
    {
        assertNull(request.getHeader(UserContext.CORRELATION_ID), "Expects no correlation header");
        assertNull(getCurrentContext().getZuulRequestHeaders().get(UserContext.CORRELATION_ID), "Expects no correlation Zuul header");

        zuulTrackingFilter.run();

        assertNotNull(getCurrentContext().getZuulRequestHeaders().get(UserContext.CORRELATION_ID), "Expects created Zuul correlation header");
    }

    @Test
    void testRunWithInitiatedCorrelationHeader() throws Exception
    {
        request.addHeader(UserContext.CORRELATION_ID, "12345");
        zuulTrackingFilter.run();

        assertEquals("12345", request.getHeader(UserContext.CORRELATION_ID), "Expects correlation id in the header");
    }
}
