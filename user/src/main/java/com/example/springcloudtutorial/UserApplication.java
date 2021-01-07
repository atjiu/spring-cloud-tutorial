package com.example.springcloudtutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RestController
@EnableFeignClients
//@RibbonClient(name = "ORDER", configuration = MyRuleConfig.class)
//@EnableHystrix
public class UserApplication {

//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
