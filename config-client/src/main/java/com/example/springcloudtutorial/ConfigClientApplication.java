package com.example.springcloudtutorial;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class ConfigClientApplication {

    @Value("${site.name:}")
    private String siteName;

    @GetMapping("/getConfig")
    public Object getConfig() {
        return "getConfig: " + siteName;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }
}
