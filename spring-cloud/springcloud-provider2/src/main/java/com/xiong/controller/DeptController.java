package com.xiong.controller;

import com.xiong.service.DeptService;
import entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author DOCO
 * 2018/12/26 16:29
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient discoveryClient;


    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {
        return deptService.add(dept);
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list() {
        return deptService.List();
    }

    @RequestMapping(value="/dept/get/{id}", method = RequestMethod.GET)
    public Dept findById(@RequestParam long id) {
        return deptService.get(id);
    }

    //服务的发现
    @RequestMapping("/dept/discover")
    public Object discoverClient() {
        List<String> list = discoveryClient.getServices();
        System.out.println(list.toString());

        List<ServiceInstance> serviceList = discoveryClient.getInstances("springcloud-provider");
        for (ServiceInstance serviceInstance : serviceList) {
            System.out.println(serviceInstance.getHost()+"******");
            System.out.println(serviceInstance.getServiceId()+"*****");
            System.out.println(serviceInstance.getPort()+"******");
        }
        return this.discoveryClient;
    }
 }
