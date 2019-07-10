package com.gy.upms.dto.application;

import java.io.Serializable;

/**
 * @Auther: guofeng
 * @Date: 2019/6/28 10:02
 * @Description:
 */
public class AppRegisterResult implements Serializable {
    private static final long serialVersionUID = 2205261779664506141L;
    private Integer id;

    private String appName;

    private String appNameEn;

    private String appToken;

    private String ipv4;

    private AppRegisterResult appAuth;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppNameEn() {
        return appNameEn;
    }

    public void setAppNameEn(String appNameEn) {
        this.appNameEn = appNameEn;
    }

    public String getAppToken() {
        return appToken;
    }

    public void setAppToken(String appToken) {
        this.appToken = appToken;
    }

    public String getIpv4() {
        return ipv4;
    }

    public void setIpv4(String ipv4) {
        this.ipv4 = ipv4;
    }

    public AppRegisterResult getAppAuth() {
        return appAuth;
    }

    public void setAppAuth(AppRegisterResult appAuth) {
        this.appAuth = appAuth;
    }

    public AppRegisterResult() {
    }

    public AppRegisterResult(Integer id, String appName, String appNameEn, String appToken, String ipv4) {
        this.id = id;
        this.appName = appName;
        this.appNameEn = appNameEn;
        this.appToken = appToken;
        this.ipv4 = ipv4;
    }

    @Override
    public String toString() {
        return "AppRegisterResult{" +
                "id=" + id +
                ", appName='" + appName + '\'' +
                ", appNameEn='" + appNameEn + '\'' +
                ", appToken='" + appToken + '\'' +
                ", ipv4='" + ipv4 + '\'' +
                ", appAuth=" + appAuth +
                '}';
    }
}
