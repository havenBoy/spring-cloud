package com.xiong.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xiong.entity.Dept;
import com.xiong.service.DeptService;
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
    @HystrixCommand(fallbackMethod = "findByIdException")
    public Dept findById(@PathVariable("id") long id) {
        Dept dept = deptService.get(id);
        if(dept == null) {
            throw new RuntimeException("没有找到该ID值的数据，ID值：" + id);
        }
        return deptService.get(id);
    }

    //当出现错误时采用此方法来返回预备的错误信息
    public Dept findByIdException(@PathVariable("id") long id) {
        return new Dept().setDeptno(id).setDname("没有该ID："+ id + "对应的数据！").setDb_source("没有在数据库中找到");
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
