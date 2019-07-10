package com.gy.upms.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class Application implements Serializable {
    private Integer id;

    private String appName;

    private String appNameEn;

    private String appToken;

    private String ipv4;

    private Integer status;

    private String remark;

    private Integer createrId;

    private String creater;

    private LocalDateTime createTime;

    private static final long serialVersionUID = 1L;

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
        this.appName = appName == null ? null : appName.trim();
    }

    public String getAppNameEn() {
        return appNameEn;
    }

    public void setAppNameEn(String appNameEn) {
        this.appNameEn = appNameEn == null ? null : appNameEn.trim();
    }

    public String getAppToken() {
        return appToken;
    }

    public void setAppToken(String appToken) {
        this.appToken = appToken == null ? null : appToken.trim();
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
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getCreaterId() {
        return createrId;
    }

    public void setCreaterId(Integer createrId) {
        this.createrId = createrId;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getIpv4() {
        return ipv4;
    }

    public void setIpv4(String ipv4) {
        this.ipv4 = ipv4;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", appName='" + appName + '\'' +
                ", appNameEn='" + appNameEn + '\'' +
                ", appToken='" + appToken + '\'' +
                ", ipv4='" + ipv4 + '\'' +
                ", status=" + status +
                ", remark='" + remark + '\'' +
                ", createrId=" + createrId +
                ", creater='" + creater + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}