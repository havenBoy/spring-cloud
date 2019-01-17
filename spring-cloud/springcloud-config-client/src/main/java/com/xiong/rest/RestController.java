package com.xiong.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author DOCO
 * 2019/1/17 16:01
 */

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Value("${spring.application.name}")
    private String applicationName;

    @RequestMapping("/config")
    public String getConfig() {
        System.out.println("打印出的" + applicationName);
        return applicationName;
    }
}
