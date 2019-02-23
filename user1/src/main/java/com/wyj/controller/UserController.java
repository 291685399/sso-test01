package com.wyj.controller;

import com.wyj.entity.vo.ApiResponse;
import com.wyj.service.SSOService;
import com.wyj.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private SSOService redisService;

    @Autowired
    private SSOService ssoService;

    private static final String USER_KEY = "user_key";

    @RequestMapping("/login")
    public Object login(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        redisService.set(CookieUtil.getLoginCookie(request, response, true), map);
        Object object = ssoService.get(CookieUtil.getLoginCookie(request, response, false));
        return ApiResponse.success(object).set("port", port);
    }

    @RequestMapping("/getUser")
    public Object getUser(HttpServletRequest request, HttpServletResponse response) {
        Object user = request.getSession().getAttribute(USER_KEY);
        Object object = ssoService.get(CookieUtil.getLoginCookie(request, response, false));
        return ApiResponse.success(object).set("port", port);
    }

}
