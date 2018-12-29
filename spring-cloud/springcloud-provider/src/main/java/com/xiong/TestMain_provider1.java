package com.xiong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author DOCO
 * 2018/12/26 16:31
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class TestMain_provider1 {

    public static void main(String[] args) {
        SpringApplication.run(TestMain_provider1.class, args);
    }
}
