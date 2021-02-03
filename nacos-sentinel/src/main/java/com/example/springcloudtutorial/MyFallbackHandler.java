package com.example.springcloudtutorial;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class MyFallbackHandler {

    public Object test_blockHandler(String name, Integer age, BlockException exception) {
        System.out.println(exception.getMessage());
        return "test_blockHandler...";
    }

    public Object test_fallback(String name, Integer age) {
        return "test_fallback...";
    }
}
