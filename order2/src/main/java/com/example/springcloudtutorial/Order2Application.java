package com.example.springcloudtutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class Order2Application {

    @PostMapping("/order/create/{userId}")
    public String create(@PathVariable("userId") String userId) throws InterruptedException {
//        TimeUnit.SECONDS.sleep(2);
        return "userId: " + userId + " create an order! server: order2";
    }

    @GetMapping("/order/{id}")
    public String getOrder(@PathVariable("id") String id) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(600);
        return "order: " + id + " server: order2";
    }

    public static void main(String[] args) {
        SpringApplication.run(Order2Application.class, args);
    }
}
