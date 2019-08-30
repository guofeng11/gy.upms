package com.gy.upms.dto.user;


import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * @Auther: guofeng
 * @Date: 2019/6/3 13:24
 * @Description:
 */
public class Register implements Serializable {
    private static final long serialVersionUID = -8888761793124185252L;

    @NotEmpty(message = "{user.name.notNull}")
    private String username;

    private String nickname;

    @NotNull
    private String password;

    @Email
    private String email;

    @NotNull
    private String phone;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Register(){}

    public Register(String username, String nickname, String password, String email, String phone) {
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }
}
