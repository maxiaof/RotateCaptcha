<p align="center"><img src="https://z3.ax1x.com/2021/11/25/okkG9I.png" alt="RotateCaptcha" style="zoom:60%;" /></p>

<h1 align="center"  style="margin: 30px 0 30px; font-weight: bold;">RotateCaptcha</h1>

## 简介：
RotateCaptcha 是一个生成旋转后图像验证码小插件

## 引入

```xml
<dependency>
    <groupId>com.maxiaofa.captcha</groupId>
    <artifactId>rotate-captcha</artifactId>
    <version>0.0.2</version>
</dependency>
```

## 配置方法

```java
public RotateCaptcha getRotateCaptchaBean() {
    RotateCaptcha rotateCaptcha = new RotateCaptcha();
    Properties properties = new Properties();
    properties.setProperty(Constants.CAPTCHA_ROTATION_FAULT,"20");
    properties.setProperty(Constants.CAPTCHA_ROTATION_ANGLE_MIN,"50");
    properties.setProperty(Constants.CAPTCHA_ROTATION_ANGLE_MAN,"300");
    properties.setProperty(Constants.CAPTCHA_ROTATION_ANGLE_OFFSET,"10");
    Config config = new Config(properties);
    rotateCaptcha.setConfig(config);
    return rotateCaptcha;
}
```

## 感谢
图像来源: [pexels](https://www.pexels.com/)