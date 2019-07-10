package com.gy.upms.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: guofeng
 * @Date: 2019/6/14 15:02
 * @Description:
 */
public class AppAndAuthInfo implements Serializable {
    private static final long serialVersionUID = -6177270249604550256L;
    private AppAuthInfo appInfo;
    private List<AppAuthInfo> authInfos;

    public AppAuthInfo getAppInfo() {
        return appInfo;
    }

    public void setAppInfo(AppAuthInfo appInfo) {
        this.appInfo = appInfo;
    }

    public List<AppAuthInfo> getAuthInfos() {
        return authInfos;
    }

    public void setAuthInfos(List<AppAuthInfo> authInfos) {
        this.authInfos = authInfos;
    }

    @Override
    public String toString() {
        return "AppAndAuthInfo{" +
                "appInfo=" + appInfo +
                ", authInfos=" + authInfos +
                '}';
    }
}
