package com.gy.upms.entity;

import java.io.Serializable;

public class UserOrg implements Serializable {
    private String id;

    private Integer userId;

    private Integer orgId;

    private Integer isRead;

    private Integer isWrite;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    public Integer getIsWrite() {
        return isWrite;
    }

    public void setIsWrite(Integer isWrite) {
        this.isWrite = isWrite;
    }

    public UserOrg() {
    }

    public UserOrg(String id, Integer userId, Integer orgId, Integer isRead, Integer isWrite) {
        this.id=id;
        this.userId = userId;
        this.orgId = orgId;
        this.isRead = isRead;
        this.isWrite = isWrite;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", orgId=").append(orgId);
        sb.append(", isRead=").append(isRead);
        sb.append(", isWrite=").append(isWrite);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}