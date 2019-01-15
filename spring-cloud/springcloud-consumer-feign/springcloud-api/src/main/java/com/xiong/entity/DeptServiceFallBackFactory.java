package com.xiong.entity;

import com.xiong.service.DeptService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author DOCO
 * 服务降级实现
 * 2019/1/15 10:27
 */
@Component
public class DeptServiceFallBackFactory implements FallbackFactory<DeptService> {

    @Override
    public DeptService create(Throwable throwable) {
        return new DeptService() {
            @Override
            public Dept get(long id) {
                return new Dept().setDeptno(id).setDname("服务已经降级，并且关闭，请稍后！").setDb_source("no data in sql");
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };
    }
}
