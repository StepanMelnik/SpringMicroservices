package com.sme.springcloud.article.service.service;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.net.URI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

/**
 * Unit tests of {@link ArticleDiscoveryService}.
 */
public class ArticleDiscoveryServiceTest
{
    @Mock
    private DiscoveryClient discoveryClient;

    @Mock
    private ServiceInstance serviecInstance1;

    @Mock
    private ServiceInstance serviecInstance2;

    private ArticleDiscoveryService articleDiscoveryService;

    @BeforeEach
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
        articleDiscoveryService = new ArticleDiscoveryService(discoveryClient);
        whens();
    }

    private void whens() throws Exception
    {
        when(discoveryClient.getServices()).thenReturn(asList("service1", "service2"));

        when(serviecInstance1.getUri()).thenReturn(new URI("http://localhost:8040"));
        when(serviecInstance2.getUri()).thenReturn(new URI("http://localhost:8050"));
        when(discoveryClient.getInstances("service1")).thenReturn(asList(serviecInstance1));
        when(discoveryClient.getInstances("service2")).thenReturn(asList(serviecInstance2));
    }

    @Test
    void testGetEurekaServices() throws Exception
    {
        assertEquals(asList("service1:http://localhost:8040", "service2:http://localhost:8050"), articleDiscoveryService.getEurekaServices());
    }
}
