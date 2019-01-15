package com.xiong.service;

import com.xiong.entity.Dept;
import com.xiong.entity.DeptServiceFallBackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author DOCO
 * 2019/1/14 8:57
 */
@FeignClient(value = "springcloud-provider-hystrix", fallbackFactory = DeptServiceFallBackFactory.class)
public interface DeptService {

    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable("id") long id);

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> list();
}
