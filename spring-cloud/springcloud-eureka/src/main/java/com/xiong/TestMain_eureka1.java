package com.xiong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author DOCO
 * 2018/12/26 16:31
 */
@SpringBootApplication
@EnableEurekaServer
public class TestMain_eureka1 {

    public static void main(String[] args) {
        SpringApplication.run(TestMain_eureka1.class, args);
    }
}
