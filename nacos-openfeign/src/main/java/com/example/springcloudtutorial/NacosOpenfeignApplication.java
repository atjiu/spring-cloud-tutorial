package com.example.springcloudtutorial;

import com.example.springcloudtutorial.service.ProviderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
public class NacosOpenfeignApplication {

    @Resource
    private ProviderService providerService;

    @GetMapping("/consumer/getOrder")
    public Object getOrder() {
        return providerService.getOrder();
    }

    public static void main(String[] args) {
        SpringApplication.run(NacosOpenfeignApplication.class, args);
    }
}
