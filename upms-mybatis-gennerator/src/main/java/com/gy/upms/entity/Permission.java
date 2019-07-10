package com.gy.upms.entity;

import java.io.Serializable;
import java.util.Date;

public class Permission implements Serializable {
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

    private String remark;

    private Integer createrId;

    private String creater;

    private Date createTime;

    private static final long serialVersionUID = 1L;

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
        this.permKey = permKey == null ? null : permKey.trim();
    }

    public String getPermNameCn() {
        return permNameCn;
    }

    public void setPermNameCn(String permNameCn) {
        this.permNameCn = permNameCn == null ? null : permNameCn.trim();
    }

    public String getPermNameEn() {
        return permNameEn;
    }

    public void setPermNameEn(String permNameEn) {
        this.permNameEn = permNameEn == null ? null : permNameEn.trim();
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
        this.permUrl = permUrl == null ? null : permUrl.trim();
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
        this.httpMethod = httpMethod == null ? null : httpMethod.trim();
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
        this.ico = ico == null ? null : ico.trim();
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appId=").append(appId);
        sb.append(", permKey=").append(permKey);
        sb.append(", permNameCn=").append(permNameCn);
        sb.append(", permNameEn=").append(permNameEn);
        sb.append(", status=").append(status);
        sb.append(", sortOrder=").append(sortOrder);
        sb.append(", level=").append(level);
        sb.append(", parentId=").append(parentId);
        sb.append(", permUrl=").append(permUrl);
        sb.append(", isNavigation=").append(isNavigation);
        sb.append(", httpMethod=").append(httpMethod);
        sb.append(", isLogin=").append(isLogin);
        sb.append(", ico=").append(ico);
        sb.append(", remark=").append(remark);
        sb.append(", createrId=").append(createrId);
        sb.append(", creater=").append(creater);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}