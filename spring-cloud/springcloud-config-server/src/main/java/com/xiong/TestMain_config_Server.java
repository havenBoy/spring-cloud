package com.xiong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author DOCO
 * 2018/12/26 16:31
 */
@SpringBootApplication
@EnableConfigServer
public class TestMain_config_Server {

    public static void main(String[] args) {
        SpringApplication.run(TestMain_config_Server.class, args);
    }
}
