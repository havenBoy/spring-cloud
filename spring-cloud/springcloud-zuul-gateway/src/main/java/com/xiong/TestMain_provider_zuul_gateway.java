package com.xiong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author DOCO
 * 2018/12/26 16:31
 */
@SpringBootApplication
@EnableZuulProxy
public class TestMain_provider_zuul_gateway {

    public static void main(String[] args) {
        SpringApplication.run(TestMain_provider_zuul_gateway.class, args);
    }
}
