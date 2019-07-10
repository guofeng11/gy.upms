package com.gy.upms.dto.user;

import java.io.Serializable;

/**
 * @Auther: guofeng
 * @Date: 2019/4/25 14:44
 * @Description:
 */
public class Login implements Serializable {

    private static final long serialVersionUID = -7083464652572271608L;

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;
}
