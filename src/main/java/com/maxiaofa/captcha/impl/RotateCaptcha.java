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

        // 计算重新绘制图片的尺寸
        Rectangle rectangle = calculatorRotatedSize(imageWidth, imageHeight, angle);

        // 获取图片透明度
        int transparency = bufferedImage.getColorModel().getTransparency();

        // 绘制验证码图片
        BufferedImage captcha = null;
        captcha = new BufferedImage(rectangle.width, rectangle.height, transparency);
        Graphics2D graphics = captcha.createGraphics();
        // 平移位置
        graphics.translate((rectangle.width - imageWidth) / 2, (rectangle.height - imageHeight) / 2);
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

    /**
     * 计算旋转后的尺寸
     * @param width 宽度
     * @param height 高度
     * @param angel 角度
     * @return 尺寸
     */
    private static Rectangle calculatorRotatedSize(int width, int height, int angel) {
        if (angel >= 90) {
            angel = angel % 90;
        }
        double r = Math.sqrt(height * height + width * width) / 2;
        double len = 2 * Math.sin(Math.toRadians(angel) / 2) * r;
        double angel_alpha = (Math.PI - Math.toRadians(angel)) / 2;
        double angel_dalta_width = Math.atan((double) height / width);
        double angel_dalta_height = Math.atan((double) width / height);

        int len_dalta_width = (int) (len * Math.cos(Math.PI - angel_alpha - angel_dalta_width));
        int len_dalta_height = (int) (len * Math.cos(Math.PI - angel_alpha - angel_dalta_height));
        int des_width = width + len_dalta_width * 2;
        int des_height = height + len_dalta_height * 2;
        return new Rectangle(new Dimension(des_width, des_height));
    }
}
