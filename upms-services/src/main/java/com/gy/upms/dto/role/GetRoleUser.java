package com.gy.upms.dto.role;

import com.gy.upms.dto.UserSecurity;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @ClassName GetRoleUser.java
 * @Author guofeng
 * @Description
 * @Version 1.0.0
 * @Date 2019年09月02日 17:36:00
 */
public class GetRoleUser implements Serializable {
    private static final long serialVersionUID = 7372808627738024533L;
    @Min(value =1 ,message = "{role.id.notNull}")
    private  Integer id;

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
