package com.gy.upms;

import com.gy.upms.component.VerifyUtils;
import com.gy.upms.entity.AppAndAuthInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Auther: guofeng
 * @Date: 2019/6/6 13:17
 * @Description: 应用程序启动 获取应用授权信息
 */
@Component
@Order(1)
public class AppAuthRunner implements ApplicationRunner {

    private static final Logger log= LoggerFactory.getLogger(AppAuthRunner.class);

    public void run(ApplicationArguments args) {
        log.debug("启动后执行");
        //启动加载授权信息
        AppAndAuthInfo appAuthInfos =VerifyUtils.getAppAuth(ApplicationProperties.getAppToken());
        //初始化权限
        VerifyUtils.getAppPerm(ApplicationProperties.getAppToken());
        //授权系统需从数据库初始化
        if (appAuthInfos.getAppInfo()==null){
            log.info("服务启动失败,未获取到配置信息");
        }
    }
}
