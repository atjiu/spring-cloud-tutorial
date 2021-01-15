package com.example.springcloudtutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class StreamProviderApplication {

    @GetMapping("/sendMsg")
    public ResponseEntity<String> sendMsg() {
        return ResponseEntity.noContent().build();
    }

    public static void main(String[] args) {
        SpringApplication.run(StreamProviderApplication.class, args);
    }
}
