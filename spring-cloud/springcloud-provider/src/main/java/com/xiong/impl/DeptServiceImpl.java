package com.xiong.impl;

import com.xiong.dao.DeptDao;
import com.xiong.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xiong.service.DeptService;

import java.util.List;

/**
 * @author DOCO
 * 2018/12/26 16:26
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public boolean add(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept get(long id) {
        return deptDao.findById(id);
    }

    @Override
    public List<Dept> List() {
        return deptDao.findAll();
    }
}
