package com.gy.upms.dto.organization;

import com.gy.upms.dto.UserSecurity;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @ClassName DetailOrg.java
 * @Author guofeng
 * @Description
 * @Version 1.0.0
 * @Date 2019年08月26日 14:00:00
 */
public class DetailOrg implements Serializable {
    private static final long serialVersionUID = -7362769297899256252L;
    @NotEmpty(message = "{organization.id.notNull}")
    private Integer id;
    @NotNull(message = "{user.security.notNull}")
    @Valid
    private UserSecurity userSecurity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserSecurity getUserSecurity() {
        return userSecurity;
    }

    public void setUserSecurity(UserSecurity userSecurity) {
        this.userSecurity = userSecurity;
    }
}
