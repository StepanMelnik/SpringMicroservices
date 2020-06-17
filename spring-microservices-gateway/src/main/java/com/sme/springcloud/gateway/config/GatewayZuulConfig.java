package com.sme.springcloud.gateway.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.sme.springcloud.common.interceptor.UserContextInterceptor;

/**
 * The gateway application configuration.
 */
@Configuration
@ComponentScan("com.sme.springcloud.common.filter")
public class GatewayZuulConfig
{
    /**
     * Load balanced rest client.
     * 
     * @return Returns rest client.
     */
    @LoadBalanced
    @Bean
    public RestTemplate loadBalancedRestTemplate()
    {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new UserContextInterceptor());
        return restTemplate;
    }
}
