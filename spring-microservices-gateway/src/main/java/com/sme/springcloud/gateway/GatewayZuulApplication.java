package com.sme.springcloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Application to start Gateway Proxy.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class GatewayZuulApplication
{
    /**
     * Entry point to start application.
     * 
     * @param args The list of arguments for JVM.
     */
    public static void main(String[] args)
    {
        SpringApplication.run(GatewayZuulApplication.class, args);
    }
}
