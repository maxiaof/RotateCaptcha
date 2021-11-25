package com.maxiaofa.captcha.utils;

/**
 * 配置属性中的错误
 * */
public class ConfigException extends RuntimeException {
    private static final long serialVersionUID = 4359709211352400087L;

    public ConfigException(String paramName, String paramValue, Throwable cause)
    {
        super("无效值 '" + paramValue + "' 或参数 '"
                + paramName + "'.", cause);
    }

    public ConfigException(String paramName, String paramValue, String message) {
        super("无效值 '" + paramValue + "' 或参数 '" + paramName + "'. " + message);
    }
}
