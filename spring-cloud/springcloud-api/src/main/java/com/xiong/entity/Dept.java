package com.xiong.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author DOCO
 * 2018/12/26 15:29
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Dept {

    private long deptno;  //部门主键

    private String dname; //部门名称

    private String db_source; //连接数据库名
}
