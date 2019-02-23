package com.wyj.entity.vo;

import java.util.HashMap;

public class ApiResponse extends HashMap {

    public static String SUCCESS_CODE = "200";
    public static String ERROR_CODE = "500";
    public static String DATA_KEY = "data";
    public static String MSG_KEY = "msg";

    private ApiResponse() {
    }

    public ApiResponse set(String key, Object object) {
        super.put(key, object);
        return this;
    }

    private static ApiResponse ok() {
        return new ApiResponse();
    }

    public static ApiResponse success() {
        return ApiResponse.ok().set("code", ApiResponse.SUCCESS_CODE).set(ApiResponse.MSG_KEY, "操作成功");
    }

    public static ApiResponse success(String msg) {
        return ApiResponse.ok().set("code", ApiResponse.SUCCESS_CODE).set(ApiResponse.MSG_KEY, msg);
    }

    public static ApiResponse success(Object value) {
        return ApiResponse.ok().set("code", ApiResponse.SUCCESS_CODE).set(ApiResponse.MSG_KEY, "操作成功").data(value);
    }

    public static ApiResponse success(String msg, Object object) {
        return ApiResponse.ok().set("code", ApiResponse.SUCCESS_CODE).set(ApiResponse.MSG_KEY, msg).set(ApiResponse.DATA_KEY, object);
    }

    public ApiResponse data(Object obj) {
        return this.set("data", obj);
    }

    public static ApiResponse error() {
        return ApiResponse.ok().set(ApiResponse.MSG_KEY, "操作失败").set("code", ApiResponse.ERROR_CODE);
    }

    public static ApiResponse error(String msg) {
        return ApiResponse.ok().set(ApiResponse.MSG_KEY, msg).set("code", ApiResponse.ERROR_CODE);
    }

    public static ApiResponse error(String msg, Object object) {
        return ApiResponse.ok().set(ApiResponse.MSG_KEY, msg).set(ApiResponse.DATA_KEY, object).set("code", ApiResponse.ERROR_CODE);
    }

}
