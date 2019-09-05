package com.gy.upms.dto.permission;

import java.io.Serializable;

/**
 * @ClassName SearchPermissionResult.java
 * @Author guofeng
 * @Description
 * @Version 1.0.0
 * @Date 2019年08月30日 15:29:00
 */
public class SearchPermissionResult implements Serializable {
    private static final long serialVersionUID = 970656562719600407L;
    private Integer id;

    private Integer appId;

    private String permKey;

    private String permNameCn;

    private String permNameEn;

    private Integer status;

    private Integer sortOrder;

    private Integer level;

    private Integer parentId;

    private String permUrl;

    private Integer isNavigation;

    private String httpMethod;

    private Integer isLogin;

    private String ico;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getPermUrl() {
        return permUrl;
    }

    public void setPermUrl(String permUrl) {
        this.permUrl = permUrl;
    }

    public Integer getIsNavigation() {
        return isNavigation;
    }

    public void setIsNavigation(Integer isNavigation) {
        this.isNavigation = isNavigation;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public Integer getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(Integer isLogin) {
        this.isLogin = isLogin;
    }

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico;
    }

    public SearchPermissionResult() {
    }

    public SearchPermissionResult(Integer id, Integer appId, String permKey, String permNameCn, String permNameEn, Integer status, Integer sortOrder, Integer level, Integer parentId, String permUrl, Integer isNavigation, String httpMethod, Integer isLogin, String ico) {
        this.id = id;
        this.appId = appId;
        this.permKey = permKey;
        this.permNameCn = permNameCn;
        this.permNameEn = permNameEn;
        this.status = status;
        this.sortOrder = sortOrder;
        this.level = level;
        this.parentId = parentId;
        this.permUrl = permUrl;
        this.isNavigation = isNavigation;
        this.httpMethod = httpMethod;
        this.isLogin = isLogin;
        this.ico = ico;
    }
}
