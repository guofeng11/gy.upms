package com.gy.upms.dto.user;

import java.io.Serializable;

/**
 * @Auther: guofeng
 * @Date: 2019/5/10 13:43
 * @Description:
 */
public class LoginResult implements Serializable {
    private static final long serialVersionUID = 4061580863511484280L;

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

    public LoginResult(){};
    public LoginResult(Integer id, String username, String nickname, String token, String email, String phone, String usertype, Integer comeform, Integer userlevel, Integer orgId, Integer jobtitleId) {
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
    }


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

    @Override
    public String toString() {
        return "LoginResult{" +
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
