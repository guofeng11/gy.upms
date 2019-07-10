package com.gy.upms.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: guofeng
 * @Date: 2019/6/14 10:04
 * @Description: 应用程序授权缓存结构
 */
public class AppAuthInfo implements Serializable {
    private static final long serialVersionUID = -7521733714002661410L;

    private Integer id;

    private String appName;

    private String appNameEn;

    private String appToken;

    private String ipv4;



    public String getIpv4() {
        return ipv4;
    }

    public void setIpv4(String ipv4) {
        this.ipv4 = ipv4;
    }

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

    public AppAuthInfo(){}
    public AppAuthInfo(Integer id, String appName, String appNameEn, String appToken, String ipv4) {
        this.id = id;
        this.appName = appName;
        this.appNameEn = appNameEn;
        this.appToken = appToken;
        this.ipv4 = ipv4;
    }

    @Override
    public String toString() {
        return "AppAuthInfo{" +
                "id=" + id +
                ", appName='" + appName + '\'' +
                ", appNameEn='" + appNameEn + '\'' +
                ", appToken='" + appToken + '\'' +
                ", ipv4='" + ipv4 + '\'' +
                '}';
    }
}