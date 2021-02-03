package com.example.springcloudtutorial;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class NacosSentinelApplication {

    @GetMapping("/test")
    @SentinelResource(
            value = "test",
            fallbackClass = MyFallbackHandler.class,
            fallback = "test_fallback",
            blockHandlerClass = MyFallbackHandler.class,
            blockHandler = "test_blockHandler"
    )
    public Object test(String name, Integer age) {
//        int a = 10 / 0;
        return "success";
    }

    // 当被热点规则限流后的处理方法
//    public Object test_blockHandler(String name, Integer age, BlockException exception) {
//        System.out.println(exception.getMessage());
//        return "test_blockHandler...";
//    }
//
//    // 当程序运行时异常后的处理方法
//    public Object test_fallback(String name, Integer age) {
//        return "test_fallback...";
//    }

    @GetMapping("/test1")
    public Object test1() throws InterruptedException {
        System.out.println("test1...");
        Thread.sleep(2000);
        return "success test1";
    }

    public static void main(String[] args) {
        SpringApplication.run(NacosSentinelApplication.class, args);
    }
}
