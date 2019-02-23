package com.wyj.service.impl;

import com.wyj.service.SSOService;
import org.springframework.stereotype.Service;

@Service("mysqlService")
public class MysqlServiceImpl implements SSOService {

    @Override
    public Object get(String key) {
        System.out.println("使用了MySql");
        return null;
    }

    @Override
    public void set(String key, Object value) {
        System.out.println("使用了MySql");
    }

}
