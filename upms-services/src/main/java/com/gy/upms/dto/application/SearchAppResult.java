package com.gy.upms.dto.application;

import java.io.Serializable;

/**
 * @Auther: guofeng
 * @Date: 2019/6/13 14:56
 * @Description:
 */

public  class  SearchAppResult implements Serializable{
    private static final long serialVersionUID = 4622200593890301910L;
    private Integer id;

    private String appName;

    private String appNameEn;

    private String appToken;

    private String ipv4;

    private Integer status;

    private String remark;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public SearchAppResult() {
    }

    public SearchAppResult(Integer id, String appName, String appNameEn, String appToken, String ipv4, Integer status, String remark) {
        this.id = id;
        this.appName = appName;
        this.appNameEn = appNameEn;
        this.appToken = appToken;
        this.ipv4 = ipv4;
        this.status = status;
        this.remark = remark;
    }
}