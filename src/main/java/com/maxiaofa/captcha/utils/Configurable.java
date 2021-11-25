package com.maxiaofa.captcha.utils;

/**
 * 通过配置管理器处理的属性来配置类
 * */
public abstract class Configurable {
    private Config config = null;

    public Config getConfig()
    {
        return this.config;
    }

    public void setConfig(Config config)
    {
        this.config = config;
    }
}
