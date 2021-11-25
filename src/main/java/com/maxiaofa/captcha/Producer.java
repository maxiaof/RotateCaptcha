package com.maxiaofa.captcha;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 负责创建旋转后的图片以及角度
 * */
public interface Producer {

    /**
     * 创建旋转后的图片
     * @param angle 角度
     * @return 旋转后的图片
     * */
    public BufferedImage createImage(int angle) throws IOException;

    /**
     * 创建旋转角度
     * @return 角度
     * */
    public int createAngle();

    /**
     * 验证验证码
     * @param angle 旋转的角度
     * @param inputAngle 输入的角度
     * @return 是否验证通过
     * */
    public boolean verify(int angle,int inputAngle);
}
