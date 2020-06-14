package com.sme.springcloud.article.service.service;

import static java.lang.String.format;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

/**
 * Discovery service to work with {@link DiscoveryClient}.
 */
@Service
public class ArticleDiscoveryService
{
    private final DiscoveryClient discoveryClient;

    public ArticleDiscoveryService(DiscoveryClient discoveryClient)
    {
        this.discoveryClient = discoveryClient;
    }

    /**
     * Fetch all services in Eureka server.
     * 
     * @return Returns a list of registered services.
     */
    public List<String> getEurekaServices()
    {
        List<String> services = new ArrayList<>();

        discoveryClient.getServices().forEach(serviceName ->
        {
            discoveryClient.getInstances(serviceName).forEach(instance ->
            {
                services.add(format("%s:%s", serviceName, instance.getUri()));
            });
        });

        return services;
    }
}
