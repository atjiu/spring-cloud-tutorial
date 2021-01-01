package com.example.springcloudtutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class Order1Application {

    @PostMapping("/order/create")
    public String create(String userId) {
        return "userId: " + userId + " create an order! server: order1";
    }

    public static void main(String[] args) {
        SpringApplication.run(Order1Application.class, args);
    }
}
