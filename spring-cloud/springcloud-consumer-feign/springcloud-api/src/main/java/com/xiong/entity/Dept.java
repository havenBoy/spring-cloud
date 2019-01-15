package com.xiong.entity;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author DOCO
 * 2018/12/26 15:29
 */
@SuppressWarnings("serial")
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Dept implements Serializable{

    private long deptno;  //部门主键

    private String dname; //部门名称

    private String db_source; //连接数据库名

}
