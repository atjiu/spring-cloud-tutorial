package com.example.springcloudtutorial;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
//@DefaultProperties(defaultFallback = "defaultFallback")
public class UserController {

    @Resource
    private IOrderService iOrderService;

    @GetMapping("/createOrder")
    @HystrixCommand(
            fallbackMethod = "defaultFallback",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2500")
            }
    )
    public Object createOrder(String userId) {
        return iOrderService.create(userId);
    }

    @GetMapping("/getOrder")
    @HystrixCommand(
            fallbackMethod = "defaultFallback",
            commandProperties = {
                    @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 开启断路器
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),// 请求阈值（默认是5）
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"), // 触发降级后要等待的时间
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),// 失败率达到多少后触发降级
            },
            threadPoolKey = "order",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "2"),
                    @HystrixProperty(name = "maxQueueSize", value = "1")
            }
    )
    public Object getOrder(String id) {
        return iOrderService.getOrder(id);
    }

    /**
     * 默认的降级处理方法.
     * <p>
     * 使用场景：当openfeign定义的接口没有实现时，如果服务发生故障，就会调用这个默认的降级处理方法
     */
    public String defaultFallback(String id) {
        return "default error fallback";
    }
}
