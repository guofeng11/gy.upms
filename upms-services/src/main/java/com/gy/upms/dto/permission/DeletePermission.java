package com.gy.upms.dto.permission;

import com.gy.upms.dto.UserSecurity;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @ClassName DeletePermission.java
 * @Author guofeng
 * @Description
 * @Version 1.0.0
 * @Date 2019年08月30日 15:28:00
 */
public class DeletePermission implements Serializable {


    private static final long serialVersionUID = -2510533107576298345L;
    @Min(value = 1,message = "{permission.id.notNull}")
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
