package com.xiong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author DOCO
 * 2018/12/27 14:56
 */
@SpringBootApplication
@EnableEurekaServer
public class TestMain_eureka3 {

    public static void main(String[] args) {
        SpringApplication.run(TestMain_eureka3.class, args);
    }
}
