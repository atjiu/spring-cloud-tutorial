package com.example.springcloudtutorial.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "nacos-provider", fallback = ProviderServiceImpl.class)
public interface ProviderService {

    @GetMapping("/getOrder")
    public Object getOrder();
}
