package com.gy.upms.services.duplex;

import com.gy.upms.dto.application.AppRegisterResult;

/**
 * @Auther: guofeng
 * @Date: 2019/6/28 09:52
 * @Description: 应用程序相关服务
 */
public interface AppService {
    /**
     * 应用程序启用 向授权中心注册
     * @param appToken 应用程序令牌
     * @return 应用程序及其授权访问的应用
     */
    AppRegisterResult register(String appToken);

    /**
     * 销毁授权中心的登录
     * @param appToken 应用令牌
     */
    void destroy(String appToken);
    void getAppPerms(String appToken);
}
