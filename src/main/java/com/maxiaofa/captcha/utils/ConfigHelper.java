package com.maxiaofa.captcha.utils;

/**
 * 解析配置
 * */
public class ConfigHelper {

    /**
     * 获得int
     * @return int
     * */
    public int getInt(String paramName, String paramValue, int defaultInt) {
        int intValue;
        if ("".equals(paramValue) || paramValue == null) {
            intValue = defaultInt;
        } else {
            try {
                intValue = Integer.parseInt(paramValue);
                if(intValue<0){
                    throw new ConfigException(paramName, paramValue, "参数不能小于0");
                }
            } catch (NumberFormatException nfe) {
                throw new ConfigException(paramName, paramValue, nfe);
            }
        }
        return intValue;
    }
}
