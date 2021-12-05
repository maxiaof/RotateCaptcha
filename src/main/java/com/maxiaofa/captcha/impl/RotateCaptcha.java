package com.maxiaofa.captcha.impl;


import com.maxiaofa.captcha.Producer;
import com.maxiaofa.captcha.utils.Configurable;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ThreadLocalRandom;

public class RotateCaptcha extends Configurable implements Producer {

    /**
     * 创建旋转后的图片
     * @param angle 角度
     * @return 旋转后的图片
     * @exception IOException 图片读取错误
     * */
    @Override
    public BufferedImage createImage(int angle) throws IOException {
        // 加载图片
        InputStream inStream = this.getClass().getResourceAsStream(CaptchaImages.getImages());
        assert inStream != null;
        BufferedImage bufferedImage = ImageIO.read(inStream);

        // 获取图片长宽
        int imageWidth = bufferedImage.getWidth(null);
        int imageHeight = bufferedImage.getHeight(null);

        // 与偏移角度相加
        angle = (angle + getConfig().getRotationAngleOffset());

        // 获取图片透明度
        int transparency = bufferedImage.getColorModel().getTransparency();

        // 绘制验证码图片
        BufferedImage captcha = null;
        // 平移位置
        captcha = new BufferedImage(imageWidth, imageHeight, transparency);
        Graphics2D graphics = captcha.createGraphics();
        graphics.translate(0, 0);
        // 旋转角度
        graphics.rotate(Math.toRadians(angle), (double) imageWidth / 2, (double) imageHeight / 2);
        // 绘图
        graphics.drawImage(bufferedImage, null, null);
        return captcha;
    }

    /**
     * 创建旋转角度
     * @return 角度
     * */
    @Override
    public int createAngle() {
        return ThreadLocalRandom.current().nextInt(getConfig().getRotationAngleMin(),getConfig().getRotationAngleMax());
    }

    /**
     * 验证验证码
     * @param angle 旋转的角度
     * @param inputAngle 输入的角度
     * @return 是否验证通过
     * */
    @Override
    public boolean verify(int angle, int inputAngle) {
        angle = angle+getConfig().getRotationAngleOffset();
        return (inputAngle >= angle && inputAngle <= angle+getConfig().getRotationFault())
                || (inputAngle <= angle &&  inputAngle >= angle-getConfig().getRotationFault());
    }
}
