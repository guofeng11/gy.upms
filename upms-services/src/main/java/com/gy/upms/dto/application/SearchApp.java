package com.gy.upms.dto.application;

import com.gy.upms.dto.InPage;
import com.gy.upms.dto.UserSecurity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Auther: guofeng
 * @Date: 2019/6/13 14:56
 * @Description:
 */

public class SearchApp implements Serializable {
    private static final long serialVersionUID = 5094398129135736528L;
    private String appName;

    private String appToken;

    private String ipv4;

    private Integer status;

    @Valid
    @NotNull(message = "{page.notNull}")
    private InPage page;

    @NotNull(message = "{user.security.notNull}")
    @Valid
    private UserSecurity userSecurity;

    public UserSecurity getUserSecurity() {
        return userSecurity;
    }

    public void setUserSecurity(UserSecurity userSecurity) {
        this.userSecurity = userSecurity;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
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

    public InPage getPage() {
        return page;
    }

    public void setPage(InPage page) {
        this.page = page;
    }
}
