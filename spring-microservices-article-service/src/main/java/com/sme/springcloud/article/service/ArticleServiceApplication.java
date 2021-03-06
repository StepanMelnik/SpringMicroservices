package com.sme.springcloud.article.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Article service application.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableCircuitBreaker
public class ArticleServiceApplication
{
    /**
     * Entry point to start application.
     * 
     * @param args The list of arguments for JVM.
     */
    public static void main(String[] args)
    {
        SpringApplication.run(ArticleServiceApplication.class, args);
    }
}
