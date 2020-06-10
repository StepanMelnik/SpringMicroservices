package com.sme.springcloud.discovery.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Application to start Eureka discovery server.
 */
@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServerApplication
{
    /**
     * Entry point to start application.
     * 
     * @param args The list of arguments for JVM.
     */
    public static void main(String[] args)
    {
        SpringApplication.run(DiscoveryServerApplication.class, args);
    }
}
