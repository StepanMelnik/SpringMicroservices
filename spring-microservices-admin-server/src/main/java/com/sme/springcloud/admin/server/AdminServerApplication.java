package com.sme.springcloud.admin.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

/**
 * <p>
 * Application to start Admin server.
 * </p>
 * See <a href="https://codecentric.github.io/spring-boot-admin/2.2.3/#getting-started">Admin Server</a> documentation.
 */
@SpringBootApplication
@EnableAdminServer
@EnableDiscoveryClient
public class AdminServerApplication
{
    /**
     * Entry point to start application.
     * 
     * @param args The list of arguments for JVM.
     */
    public static void main(String[] args)
    {
        SpringApplication.run(AdminServerApplication.class, args);
    }
}
