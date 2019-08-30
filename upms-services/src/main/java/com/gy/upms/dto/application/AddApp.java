package com.gy.upms.dto.application;

import com.gy.upms.dto.UserSecurity;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Auther: guofeng
 * @Date: 2019/6/13 14:55
 * @Description: 应用添加
 */
public class AddApp implements Serializable {
    private static final long serialVersionUID = -734665678105058631L;

    @NotEmpty(message = "{app.name.notNull}")
    private String appName;
    @NotEmpty(message = "{app.name.en.notNull}")
    private String appNameEn;

    private String appToken;
    @NotEmpty(message = "{app.ip.notNull}")
    private String ipv4;

    private String remark;
    private String creater;
    @NotNull(message = "{user.security.notNull}")
    @Valid
    private UserSecurity userSecurity;

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

    public AddApp() {
    }

    public AddApp(String appName, String appNameEn, String appToken, String ipv4,  String remark, String creater, UserSecurity userSecurity) {
        this.appName = appName;
        this.appNameEn = appNameEn;
        this.appToken = appToken;
        this.ipv4 = ipv4;
        this.remark = remark;
        this.creater = creater;
        this.userSecurity = userSecurity;
    }

    public AddApp(String appName, String appNameEn, String appToken, String ipv4,  String remark,Integer createrId, String creater,String token) {
        this.appName = appName;
        this.appNameEn = appNameEn;
        this.appToken = appToken;
        this.ipv4 = ipv4;
        this.remark = remark;
        this.creater = creater;
        this.userSecurity=new UserSecurity(createrId,token);
    }
}
