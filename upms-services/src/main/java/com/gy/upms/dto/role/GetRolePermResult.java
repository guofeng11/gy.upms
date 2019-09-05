package com.gy.upms.dto.role;

import java.io.Serializable;

/**
 * @ClassName GetRolePermResult.java
 * @Author guofeng
 * @Description
 * @Version 1.0.0
 * @Date 2019年09月02日 17:41:00
 */
public class GetRolePermResult implements Serializable {
    private static final long serialVersionUID = 4310533802840331612L;

    private Integer permId;

    private Integer appId;

    private String permKey;

    private String permNameCn;

    private String permNameEn;

    private Integer sortOrder;

    private Integer level;

    private Integer parentId;

    public Integer getPermId() {
        return permId;
    }

    public void setPermId(Integer permId) {
        this.permId = permId;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getPermKey() {
        return permKey;
    }

    public void setPermKey(String permKey) {
        this.permKey = permKey;
    }

    public String getPermNameCn() {
        return permNameCn;
    }

    public void setPermNameCn(String permNameCn) {
        this.permNameCn = permNameCn;
    }

    public String getPermNameEn() {
        return permNameEn;
    }

    public void setPermNameEn(String permNameEn) {
        this.permNameEn = permNameEn;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public GetRolePermResult() {
    }

    public GetRolePermResult(Integer permId, Integer appId, String permKey, String permNameCn, String permNameEn, Integer sortOrder, Integer level, Integer parentId) {
        this.permId = permId;
        this.appId = appId;
        this.permKey = permKey;
        this.permNameCn = permNameCn;
        this.permNameEn = permNameEn;
        this.sortOrder = sortOrder;
        this.level = level;
        this.parentId = parentId;
    }
}
