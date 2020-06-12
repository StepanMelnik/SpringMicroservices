package com.sme.springcloud.articleattribute.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Article attribute service application.
 */
@SpringBootApplication
@EnableEurekaClient
public class ArticleAttributeServiceApplication
{
    /**
     * Entry point to start application.
     * 
     * @param args The list of arguments for JVM.
     */
    public static void main(String[] args)
    {
        SpringApplication.run(ArticleAttributeServiceApplication.class, args);
    }
}
