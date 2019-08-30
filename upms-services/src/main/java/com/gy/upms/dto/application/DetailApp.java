package com.gy.upms.dto.application;

import com.gy.upms.dto.UserSecurity;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Auther: guofeng
 * @Date: 2019/6/13 14:56
 * @Description:
 */
public class DetailApp implements Serializable {
    private static final long serialVersionUID = 2100878418824175281L;
    @Min(value = 1,message = "{app.id.notNull}")
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
