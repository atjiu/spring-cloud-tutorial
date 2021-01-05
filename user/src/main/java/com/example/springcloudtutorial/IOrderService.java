package com.example.springcloudtutorial;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient(value = "ORDER")
public interface IOrderService {

    @PostMapping("/order/create/{userId}")
    String create(@PathVariable("userId") String userId);

    @GetMapping("/order/{id}")
    String getOrder(@PathVariable("id") String id);

}
