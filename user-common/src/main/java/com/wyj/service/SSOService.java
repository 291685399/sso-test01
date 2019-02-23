package com.wyj.service;

public interface SSOService {

    /**
     * 根据key获取用户信息map
     *
     * @param key
     * @return
     */
    public Object get(String key);

    /**
     * 设置key和用户信息map
     *
     * @param key
     * @param value
     */
    public void set(String key, Object value);

}
