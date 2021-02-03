package com.example.springcloudtutorial.service;

import org.springframework.stereotype.Component;

@Component
public class ProviderServiceImpl implements ProviderService {
    @Override
    public Object getOrder() {
        return "ProviderServiceImpl -- getOrder";
    }
}
