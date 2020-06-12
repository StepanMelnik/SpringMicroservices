package com.sme.springcloud.articleprice.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Article price service application.
 */
@SpringBootApplication
@EnableEurekaClient
public class ArticlePriceServiceApplication
{
    /**
     * Entry point to start application.
     * 
     * @param args The list of arguments for JVM.
     */
    public static void main(String[] args)
    {
        SpringApplication.run(ArticlePriceServiceApplication.class, args);
    }
}
