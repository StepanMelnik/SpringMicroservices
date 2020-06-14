package com.sme.springcloud.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Application to start Config server.
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ConfigServerApplication
{
    /**
     * Entry point to start application.
     * 
     * @param args The list of arguments for JVM.
     */
    public static void main(String[] args)
    {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
