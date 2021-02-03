package com.example.springcloudtutorial;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class NacosProvider1Application {

    @Value("${server.port}")
    private int port;

    @GetMapping("/getOrder")
    public Object getOrder() {
        return "order list " + port;
    }

    public static void main(String[] args) {
        SpringApplication.run(NacosProvider1Application.class, args);
    }
}
