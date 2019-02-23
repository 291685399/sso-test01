package com.wyj.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

    public static final String COOKIE_KEY = "LOGIN_COOKIE";

    /**
     * 根据cookie的key获取登录信息中的cookie的值
     *
     * @param request
     * @param response
     * @param isCreate
     * @return
     */
    public static String getLoginCookie(HttpServletRequest request, HttpServletResponse response, boolean isCreate) {
        for (Cookie cookie : request.getCookies()) {
            String name = cookie.getName();
            if (COOKIE_KEY.equals(name)) {
                if (cookie.getValue() != null) {
                    return cookie.getValue();
                } else {
                    if (!isCreate) {
                        return null;
                    }
                }
            }
        }
        String UUID = java.util.UUID.randomUUID().toString();
        Cookie cookie = new Cookie(COOKIE_KEY, UUID);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        return UUID;
    }
}
