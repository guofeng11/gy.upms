package com.gy.upms.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Auther: guofeng
 * @Date: 2019/6/4 15:01
 * @Description:
 */
public class UserLoginInfo implements Serializable {
    private static final long serialVersionUID = -2770117700080888717L;
    private Integer id;

    private String username;

    private String nickname;

    private String token;

    private String email;

    private String phone;

    private String usertype;

    private Integer comeform;

    private Integer userlevel;

    private Integer orgId;

    private Integer jobtitleId;

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    private LocalDateTime loginTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public UserLoginInfo(){}
    public UserLoginInfo(Integer id, String username, String nickname, String token, String email, String phone, String usertype,
                         Integer comeform, Integer userlevel, Integer orgId, Integer jobtitleId,LocalDateTime loginTime) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
        this.token = token;
        this.email = email;
        this.phone = phone;
        this.usertype = usertype;
        this.comeform = comeform;
        this.userlevel = userlevel;
        this.orgId = orgId;
        this.jobtitleId = jobtitleId;
        this.loginTime=loginTime;
    }

    @Override
    public String toString() {
        return "UserLoginInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", token='" + token + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", usertype='" + usertype + '\'' +
                ", comeform=" + comeform +
                ", userlevel=" + userlevel +
                ", orgId=" + orgId +
                ", jobtitleId=" + jobtitleId +
                '}';
    }
}
