package com.example.springcloudtutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.Message;

import java.util.Map;

@SpringBootApplication
@EnableBinding(Processor.class)
public class StreamConsumer1Application {

    @StreamListener(Processor.INPUT)
    public void receiveMsg(Message<Map<String, Object>> message) {
        Map<String, Object> payload = message.getPayload();
//        String user = payload.get("user").toString(); // throw nullpointexception
        System.out.println("consumer2: " + payload.toString());
    }

    public static void main(String[] args) {
        SpringApplication.run(StreamConsumer1Application.class, args);
    }
}
