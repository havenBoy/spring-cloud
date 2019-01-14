package com.xiong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author DOCO
 * 2018/12/27 9:57
 */

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class TestMain_Consumer_Feign {
    public static void main(String[] args) {
        SpringApplication.run(TestMain_Consumer_Feign.class, args);
    }
}
