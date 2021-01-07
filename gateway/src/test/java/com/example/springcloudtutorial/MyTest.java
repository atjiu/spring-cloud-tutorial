package com.example.springcloudtutorial;

import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

public class MyTest {

    @Test
    public void test1() {
        ZonedDateTime zdt = ZonedDateTime.now();
        System.out.println(zdt.toString()); //2021-01-06T10:22:00.227+08:00[Asia/Shanghai]
    }
}
