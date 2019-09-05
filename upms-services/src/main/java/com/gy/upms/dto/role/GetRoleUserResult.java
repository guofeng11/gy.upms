package com.gy.upms.dto.role;

import java.io.Serializable;

/**
 * @ClassName GetRoleUserResult.java
 * @Author guofeng
 * @Description
 * @Version 1.0.0
 * @Date 2019年09月02日 17:39:00
 */
public class GetRoleUserResult implements Serializable {
    private static final long serialVersionUID = 8191058076713445318L;
    private  Integer userId;

    private String userName;

    private String phone;
    private String email;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public GetRoleUserResult() {
    }

    public GetRoleUserResult(Integer userId, String userName, String phone, String email) {
        this.userId = userId;
        this.userName = userName;
        this.phone = phone;
        this.email = email;
    }
}
