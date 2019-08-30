package com.gy.upms.dto.application;

import com.gy.upms.dto.UserSecurity;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @Auther: guofeng
 * @Date: 2019/6/13 14:57
 * @Description:
 */
public class SetApp implements Serializable {

    private static final long serialVersionUID = -7539126752697226876L;

    @Min(value = 1,message = "{app.id.notNull}")
    private Integer appId;
    @Min(value = 1,message = "{app.id.notNull}")
    private Integer authAppId;

    private List<Integer> permIds;
    @NotNull(message = "{user.security.notNull}")
    @Valid
    private UserSecurity userSecurity;

    public List<Integer> getPermIds() {
        return permIds;
    }

    public void setPermIds(List<Integer> permIds) {
        this.permIds = permIds;
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

    public UserSecurity getUserSecurity() {
        return userSecurity;
    }

    public void setUserSecurity(UserSecurity userSecurity) {
        this.userSecurity = userSecurity;
    }
}
