package com.example.springcloudtutorial;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@EnableBinding(Processor.class)
public class MessageProviderService {

    @Resource
    private MessageChannel output;

    public String send() {
        String uuid = UUID.randomUUID().toString();
        Map<String, Object> payload = new HashMap<>();
        payload.put("uuid", uuid);
        output.send(MessageBuilder.withPayload(payload).build());
        return uuid;
    }

}
