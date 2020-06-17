package com.sme.springcloud.gateway;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sme.springcloud.gateway.filter.ZuulTrackingFilter;

/**
 * Unit tests of {@link GatewayZuulApplication}.
 */
@SpringBootTest(classes = GatewayZuulApplication.class)
public class GatewayZuulApplicationTest
{
    @Autowired
    private ZuulTrackingFilter zuulTrackingFilter;

    @Test
    void testContext() throws Exception
    {
        assertNotNull(zuulTrackingFilter, "Expects started context");
    }
}
