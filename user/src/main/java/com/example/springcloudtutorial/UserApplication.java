package com.example.springcloudtutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RestController
@EnableFeignClients
//@RibbonClient(name = "ORDER", configuration = MyRuleConfig.class)
public class UserApplication {

//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }

    @Resource
    private IOrderService orderService;

    @GetMapping("/createOrder")
    public Object createOrder(String userId) {
//        ResponseEntity<String> forEntity = restTemplate().getForEntity("http://ORDER/order/create?userId=" + userId, String.class);
//        return forEntity.getBody();

        return orderService.create(userId);
    }

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
