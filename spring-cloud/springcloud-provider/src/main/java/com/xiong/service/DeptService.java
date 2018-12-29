package com.xiong.service;

import entity.Dept;

import java.util.List;

/**
 * @author DOCO
 * 2018/12/26 16:23
 */
public interface DeptService {

    public boolean add(Dept dept);

    public Dept get(long id);

    public List<Dept> List();
}
