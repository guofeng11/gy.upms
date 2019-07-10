package com.gy.upms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Auther: guofeng
 * @Date: 2019/6/17 16:34
 * @Description: 获取配置文件值
 */
@Component
public class ApplicationProperties {
    private static String appName;

    private static String appToken;

    private static Boolean setPermDefault;





    @Value("${spring.application.name}")
    public  void setAppName(String appName) {
        ApplicationProperties.appName = appName;
    }
    @Value("${application.token}")
    public  void setAppToken(String appToken) {
        ApplicationProperties.appToken = appToken;
    }
    @Value("${application.unset.default}")
    public  void setSetPermDefault(Boolean setPermDefault) {
        ApplicationProperties.setPermDefault = setPermDefault;
    }

    public static Boolean getSetPermDefault() {
        return setPermDefault;
    }

    public static String getAppName() {
        return appName;
    }

    public static String getAppToken() {
        return appToken;
    }


}
