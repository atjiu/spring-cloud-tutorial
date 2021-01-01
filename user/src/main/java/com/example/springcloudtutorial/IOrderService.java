package com.example.springcloudtutorial;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient("ORDER")
public interface IOrderService {

    @PostMapping("/order/create")
    String create(String userId);

}
