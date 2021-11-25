package com.maxiaofa.captcha.impl;

import java.util.concurrent.ThreadLocalRandom;

public class CaptchaImages {

    /**
     * 图像数组
     * */
    private static final String[] CAPTCHA_IMAGES = new String[]{
            "/images/m_1.png","/images/m_2.png","/images/m_3.png","/images/m_4.png",
            "/images/m_5.png","/images/m_6.png","/images/m_7.png","/images/m_8.png",
            "/images/m_9.png","/images/m_10.png","/images/m_11.png","/images/m_12.png",
            "/images/m_13.png","/images/m_14.png","/images/m_15.png","/images/m_16.png",
            "/images/m_17.png","/images/m_18.png","/images/m_19.png","/images/m_20.png",
    };

    /**
     * 获取图像
     * @return 图像地址
     * */
    public static String getImages() {
        int randomContext = CAPTCHA_IMAGES.length;
        int index = ThreadLocalRandom.current().nextInt(0, randomContext);
        return CAPTCHA_IMAGES[index];
    }
}
