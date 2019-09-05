package com.gy.upms.dto.jobTitle;

import com.gy.upms.dto.UserSecurity;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @ClassName DetailJobTitle.java
 * @Author guofeng
 * @Description
 * @Version 1.0.0
 * @Date 2019年09月03日 14:00:00
 */
public class DetailJobTitle implements Serializable {
    private static final long serialVersionUID = -1326585346296646661L;

    @Min(value =1 ,message = "{jobTitle.id.notNull}")
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
