package com.sme.springcloud.articlename.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Article name service application.
 */
@SpringBootApplication
@EnableEurekaClient
public class ArticleNameServiceApplication
{
    /**
     * Entry point to start application.
     * 
     * @param args The list of arguments for JVM.
     */
    public static void main(String[] args)
    {
        SpringApplication.run(ArticleNameServiceApplication.class, args);
    }
}
