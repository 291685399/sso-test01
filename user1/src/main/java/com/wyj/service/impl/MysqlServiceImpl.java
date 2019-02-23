package com.wyj.service.impl;

import com.wyj.service.SSOService;
import org.springframework.stereotype.Service;

@Service("mysqlService")
public class MysqlServiceImpl implements SSOService {

    @Override
    public Object get(String key) {
        System.out.println("使用mysql获取用户信息");
        return null;
    }

    @Override
    public void set(String key, Object value) {
        System.out.println("将用户信息存储在mysql中");
    }

}
