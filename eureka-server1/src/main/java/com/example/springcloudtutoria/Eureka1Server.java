package com.example.springcloudtutoria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Eureka1Server {

    public static void main(String[] args) {
        SpringApplication.run(Eureka1Server.class, args);
    }
}
