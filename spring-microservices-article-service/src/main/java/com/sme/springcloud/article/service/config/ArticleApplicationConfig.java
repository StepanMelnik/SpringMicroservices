package com.sme.springcloud.article.service.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * The application configuration.
 */
@Configuration
public class ArticleApplicationConfig
{
    /**
     * Load balanced web client.
     * 
     * @return Returns web client bean.
     */
    @LoadBalanced
    @Bean
    public WebClient.Builder loadBalancedWebClientBuilder()
    {
        return WebClient.builder();
    }

    /**
     * Load balanced rest client.
     * 
     * @return Returns rest client.
     */
    @LoadBalanced
    @Bean
    public RestTemplate loadBalancedRestTemplate()
    {
        return new RestTemplate();
    }
}
