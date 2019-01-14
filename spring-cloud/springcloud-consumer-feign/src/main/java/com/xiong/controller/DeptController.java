package com.xiong.controller;

import com.xiong.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xiong.service.DeptService;

import java.util.List;

/**
 * @author DOCO
 * 2018/12/27 9:35
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping("/consumer/list")
    public List<Dept> findAll() {
        return deptService.list();
    }

    @RequestMapping("/consumer/get/{id}")
    public Dept findById(@PathVariable long id) {
        return deptService.get(id);
    }

}
