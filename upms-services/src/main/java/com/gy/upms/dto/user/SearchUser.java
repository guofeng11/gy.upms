package com.gy.upms.dto.user;

import com.gy.upms.dto.InPage;
import com.gy.upms.dto.UserSecurity;

import java.io.Serializable;

/**
 * @Auther: guofeng
 * @Date: 2019/6/10 13:25
 * @Description:
 */
public class SearchUser implements Serializable {
    private static final long serialVersionUID = -3668470153414995528L;

    private String username;

    private String email;

    private Integer Status;

    private String phone;

    private String usertype;

    private Integer comeform;

    private Integer userlevel;

    private Integer orgId;

    private Integer jobtitleId;

    private InPage page;

    private UserSecurity userSecurity;


    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public UserSecurity getUserSecurity() {
        return userSecurity;
    }

    public void setUserSecurity(UserSecurity userSecurity) {
        this.userSecurity = userSecurity;
    }

    public InPage getPage() {
        return page;
    }

    public void setPage(InPage page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "SearchUser{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", usertype='" + usertype + '\'' +
                ", comeform=" + comeform +
                ", userlevel=" + userlevel +
                ", orgId=" + orgId +
                ", jobtitleId=" + jobtitleId +
                ", page=" + page +
                ", userSecurity=" + userSecurity +
                '}';
    }
}
