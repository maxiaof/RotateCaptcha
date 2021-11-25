package com.maxiaofa.captcha.utils;


import com.maxiaofa.captcha.Constants;

import java.util.Properties;

/**
 * 配置
 * */
public class Config {

    /**
     * 读取配置
     * */
    private final Properties properties;

    /**
     * 解析配置
     * */
    private final ConfigHelper helper;

    /**
     * 加载配置
     * */
    public Config(Properties properties) {
        this.properties = properties;
        this.helper = new ConfigHelper();
    }

    /**
     * 偏移角度
     * @return 偏移角度 默认10
     * */
    public int getRotationAngleOffset(){
        String paramName = Constants.CAPTCHA_ROTATION_ANGLE_OFFSET;
        String paramValue = this.properties.getProperty(paramName);
        return this.helper.getInt(paramName, paramValue, 10);
    }

    /**
     * 最大旋转角度
     * @return 最大角度 默认300
     * */
    public int getRotationAngleMax(){
        String paramName = Constants.CAPTCHA_ROTATION_ANGLE_MAX;
        String paramValue = this.properties.getProperty(paramName);
        return this.helper.getInt(paramName, paramValue, 300);
    }

    /**
     * 最小旋转角度
     * @return 最小角度 默认50
     * */
    public int getRotationAngleMin(){
        String paramName = Constants.CAPTCHA_ROTATION_ANGLE_MIN;
        String paramValue = this.properties.getProperty(paramName);
        return this.helper.getInt(paramName, paramValue, 50);
    }

    /**
     * 容错角度
     * @return 容错角度 默认20
     * */
    public int getRotationFault() {
        String paramName = Constants.CAPTCHA_ROTATION_FAULT;
        String paramValue = this.properties.getProperty(paramName);
        return this.helper.getInt(paramName, paramValue, 20);
    }
}
