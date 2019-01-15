package com.xiong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author DOCO
 * 2018/12/27 9:57
 */

@SpringBootApplication
@EnableHystrixDashboard
public class TestMain_Consumer_Hystrix_DashBoard {
    public static void main(String[] args) {
        SpringApplication.run(TestMain_Consumer_Hystrix_DashBoard.class, args);
    }
}
