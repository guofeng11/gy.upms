package com.gy.upms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Auther: guofeng
 * @Date: 2019/6/17 16:34
 * @Description: &#x83b7;&#x53d6;&#x914d;&#x7f6e;&#x6587;&#x4ef6;&#x503c;
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

    /**
     * 配置权限默认是否允许访问 true 允许
     * @return
     */
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
