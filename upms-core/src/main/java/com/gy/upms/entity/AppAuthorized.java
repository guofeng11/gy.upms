package com.gy.upms.entity;

import java.io.Serializable;

public class AppAuthorized implements Serializable {
    private String id;

    private Integer appId;

    private Integer authAppId;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public Integer getAuthAppId() {
        return authAppId;
    }

    public void setAuthAppId(Integer authAppId) {
        this.authAppId = authAppId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appId=").append(appId);
        sb.append(", authAppId=").append(authAppId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}