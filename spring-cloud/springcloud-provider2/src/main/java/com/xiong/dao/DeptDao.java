package com.xiong.dao;

import entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author DOCO
 * 2018/12/26 16:12
 */
@Mapper
public interface DeptDao {

    public boolean addDept(Dept dept);

    public Dept findById(long id);

    public List<Dept> findAll();
}
