package com.example.springcloudtutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@SpringBootApplication
@RestController
public class StreamProviderApplication {

    @Resource
    private MessageProviderService messageProviderService;

    @GetMapping("/sendMsg")
    public ResponseEntity<String> sendMsg() {
        String uuid = messageProviderService.send();
        System.out.println("provider: " + uuid);
        return ResponseEntity.ok(uuid);
    }

    public static void main(String[] args) {
        SpringApplication.run(StreamProviderApplication.class, args);
    }
}
