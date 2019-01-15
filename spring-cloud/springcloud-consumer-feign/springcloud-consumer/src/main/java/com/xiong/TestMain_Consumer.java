package com.xiong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author DOCO
 * 2018/12/27 9:57
 */

@SpringBootApplication
@EnableEurekaClient
public class TestMain_Consumer {
    public static void main(String[] args) {
        SpringApplication.run(TestMain_Consumer.class, args);
    }
}
