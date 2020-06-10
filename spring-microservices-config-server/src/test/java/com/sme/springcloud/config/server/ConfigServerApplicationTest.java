package com.sme.springcloud.config.server;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.discovery.DiscoveryClient;

/**
 * Unit tests of {@link ConfigServerApplication}.
 */
@SpringBootTest(classes = ConfigServerApplication.class)
public class ConfigServerApplicationTest
{
    @Autowired
    private DiscoveryClient discoveryClient;

    @Test
    public void testContextCreated() throws Exception
    {
        assertNotNull(discoveryClient, "Expects started context");
    }
}
