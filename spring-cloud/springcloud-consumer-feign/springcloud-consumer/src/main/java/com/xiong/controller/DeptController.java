package com.xiong.controller;

import com.xiong.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author DOCO
 * 2018/12/27 9:35
 */
@RestController
public class DeptController {

    private static final String path = "http://springcloud-provider-hystrix";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/list")
    public List<Dept> findAll() {
        return restTemplate.getForObject(path+"/dept/list", List.class);
    }

    @RequestMapping("/consumer/get/{id}")
    public Dept findById(@PathVariable long id) {
        return restTemplate.getForObject(path+"/dept/get/" + id, Dept.class);
    }

    @RequestMapping("/consumer/discover")
    public Object discoverClient() {
        return restTemplate.getForObject(path+"/dept/discover", Object.class);
    }
}
