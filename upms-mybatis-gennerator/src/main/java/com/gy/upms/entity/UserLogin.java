package com.gy.upms.entity;

import java.io.Serializable;
import java.util.Date;

public class UserLogin implements Serializable {
    private Integer userId;

    private String token;

    private Date loginTime;

    private Integer expDur;

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Integer getExpDur() {
        return expDur;
    }

    public void setExpDur(Integer expDur) {
        this.expDur = expDur;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", token=").append(token);
        sb.append(", loginTime=").append(loginTime);
        sb.append(", expDur=").append(expDur);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}