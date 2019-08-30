package com.gy.upms.dto.permission;

import com.gy.upms.dto.UserSecurity;

import java.io.Serializable;

/**
 * @ClassName UserPermission.java
 * @Author guofe
 * @Description 用户权限
 * @Version 1.0.0
 * @Date 2019年07月25日 14:35:00
 */
public class UserPermission implements Serializable {
    private static final long serialVersionUID = 2476822021160795534L;

    private UserSecurity userSecurity;

    public UserSecurity getUserSecurity() {
        return userSecurity;
    }

    public void setUserSecurity(UserSecurity userSecurity) {
        this.userSecurity = userSecurity;
    }

    public UserPermission() {
    }

    public UserPermission(int userId, String token) {
        this.userSecurity=new UserSecurity(userId,token);
    }
}
