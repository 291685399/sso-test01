package com.wyj.factory;

import com.wyj.service.SSOService;
import com.wyj.service.impl.MysqlServiceImpl;
import com.wyj.service.impl.RedisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class SSOFactory {

    @Autowired
    public RedisServiceImpl redisService;

    @Autowired
    public MysqlServiceImpl mysqlService;

    public SSOService getStore(String storeType) {

        switch (storeType) {
            case "redis":
                return redisService;
            case "mysql":
                return mysqlService;
        }
        return redisService;
    }
}
