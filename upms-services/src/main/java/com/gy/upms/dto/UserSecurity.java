package com.gy.upms.dto;

import java.io.Serializable;

/**
 * @Auther: guofeng
 * @Date: 2019/6/3 13:21
 * @Description: 需要验证用户是否登录时 参数
 */
public class UserSecurity implements Serializable {
    private static final long serialVersionUID = -3310613673614133459L;

    private Integer id;
    private  String token;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserSecurity(Integer id, String token) {
        this.id = id;
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserSecurity{" +
                "id=" + id +
                ", token='" + token + '\'' +
                '}';
    }
}
