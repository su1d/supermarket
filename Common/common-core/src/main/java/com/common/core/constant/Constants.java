package com.common.core.constant;

public class Constants {

    /**
     * 自动识别json对象白名单配置（仅允许解析的包名，范围越小越安全）
     */
    public static final String[] JSON_WHITELIST_STR = { "org.springframework", "com.ruoyi" };

    //token用户名
    public static final String LOGIN_USERNAME = "userName";

    //token存活时间
    public static final String LOGIN_EXPIRETIME= "exp";
}
