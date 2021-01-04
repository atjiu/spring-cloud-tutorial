package com.example.springcloudtutorial;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient(value = "ORDER", fallback = OrderService.class)
public interface IOrderService {

    @PostMapping("/order/create/{userId}")
    String create(@PathVariable("userId") String userId);

}
