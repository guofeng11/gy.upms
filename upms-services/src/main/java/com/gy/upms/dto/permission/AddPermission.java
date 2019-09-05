package com.gy.upms.dto.permission;

import com.gy.upms.dto.TrueFalse;
import com.gy.upms.dto.UserSecurity;
import com.gy.upms.validation.EnumValidAnnotation;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @ClassName AddPermission.java
 * @Author guofeng
 * @Description
 * @Version 1.0.0
 * @Date 2019年08月30日 15:27:00
 */
public class AddPermission implements Serializable {

    private static final long serialVersionUID = -2073691426448989117L;
    @Min(value = 1,message = "{app.id.notNull}")
    private Integer appId;

    private String permKey;

    @NotEmpty(message = "{permission.name.cn.notNull}")
    private String permNameCn;
    @NotEmpty(message = "{permission.name.en.notNull}")
    private String permNameEn;

    @Min(value = 1,message = "{permission.sort.notNull}")
    private Integer sortOrder;
    @Min(value = 1,message = "{permission.level.notNull}")
    private Integer level;
    @Min(value = 0,message = "{permission.parent.notNull}")
    private Integer parentId;

    private String permUrl;

    @EnumValidAnnotation(value = TrueFalse.class,inputMethod = "getIntValue",message = "{permission.navigation.notNull}")
    private Integer isNavigation;

    //多个|分隔
    @NotEmpty(message = "")
    private String httpMethod;
    @EnumValidAnnotation(value = TrueFalse.class,inputMethod = "getIntValue",message = "{permission.login.notNull}")
    private Integer isLogin;

    private String ico;

    private String remark;

    private String creater;

    @NotNull(message = "{user.security.notNull}")
    @Valid
    private UserSecurity userSecurity;

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public UserSecurity getUserSecurity() {
        return userSecurity;
    }

    public void setUserSecurity(UserSecurity userSecurity) {
        this.userSecurity = userSecurity;
    }
}
