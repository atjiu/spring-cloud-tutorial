package com.example.springcloudtutorial;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class UserController {

    @Resource
    private IOrderService iOrderService;

    @GetMapping("/createOrder")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    public Object createOrder(String userId) {
//        ResponseEntity<String> forEntity = restTemplate().getForEntity("http://ORDER/order/create?userId=" + userId, String.class);
//        return forEntity.getBody();
        return iOrderService.create(userId);
    }

    /**
     * 默认的降级处理方法.
     * <p>
     * 使用场景：当openfeign定义的接口没有实现时，如果服务发生故障，就会调用这个默认的降级处理方法
     */
    public String defaultFallback() {
        return "default error fallback";
    }
}
