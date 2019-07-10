package com.gy.upms.dto.user;

import com.gy.upms.dto.UserSecurity;

import java.io.Serializable;

/**
 * @Auther: guofeng
 * @Date: 2019/6/10 13:38
 * @Description:
 */
public class DetailUser implements Serializable {
    private static final long serialVersionUID = -2154551875200021261L;
    private int id;
    private UserSecurity userSecurity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserSecurity getUserSecurity() {
        return userSecurity;
    }

    public void setUserSecurity(UserSecurity userSecurity) {
        this.userSecurity = userSecurity;
    }
}
