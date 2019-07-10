package com.gy.upms.dto.user;

import com.gy.upms.dto.UserSecurity;

import java.io.Serializable;

/**
 * @Auther: guofeng
 * @Date: 2019/6/3 13:17
 * @Description: 后台添加用户
 */
public class AddUser implements Serializable {
    private static final long serialVersionUID = 5361410558273691790L;

    private String username;

    private String nickname;

    private String password;

    private String email;

    private String phone;

    private String usertype;

    private Integer comeform;

    private Integer userlevel;

    private Integer orgId;

    private Integer jobtitleId;

    private String creater;

    private UserSecurity userSecurity;

    public UserSecurity getUserSecurity() {
        return userSecurity;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public void setUserSecurity(UserSecurity userSecurity) {
        this.userSecurity = userSecurity;
    }

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

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public Integer getComeform() {
        return comeform;
    }

    public void setComeform(Integer comeform) {
        this.comeform = comeform;
    }

    public Integer getUserlevel() {
        return userlevel;
    }

    public void setUserlevel(Integer userlevel) {
        this.userlevel = userlevel;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getJobtitleId() {
        return jobtitleId;
    }

    public void setJobtitleId(Integer jobtitleId) {
        this.jobtitleId = jobtitleId;
    }


    public AddUser(String username, String password, String email, String phone, String usertype,Integer orgId) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.usertype = usertype;
        this.orgId = orgId;
    }

    public AddUser(String username, String nickname, String password, String email, String phone, String usertype, Integer comeform, Integer userlevel, Integer orgId, Integer jobtitleId,String creater, UserSecurity userSecurity) {
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.usertype = usertype;
        this.comeform = comeform;
        this.userlevel = userlevel;
        this.orgId = orgId;
        this.jobtitleId = jobtitleId;
        this.creater=creater;
        this.userSecurity = userSecurity;
    }
}
