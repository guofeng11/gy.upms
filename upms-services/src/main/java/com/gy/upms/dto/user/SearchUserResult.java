package com.gy.upms.dto.user;

import com.gy.upms.dto.OutPage;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: guofeng
 * @Date: 2019/6/10 13:26
 * @Description:
 */
public class SearchUserResult implements Serializable {


    private static final long serialVersionUID = 5478520418018657832L;
    private Integer id;

    private String username;

    private String nickname;

    private String email;

    private String phone;

    private String usertype;

    private Integer comeform;

    private Integer userlevel;

    private Integer orgId;

    private Integer jobtitleId;

    private String create_time;

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

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public SearchUserResult() {
    }

    public SearchUserResult(Integer id, String username, String nickname, String email, String phone, String usertype,
                            Integer comeform, Integer userlevel, Integer orgId, Integer jobtitleId, String create_time) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
        this.email = email;
        this.phone = phone;
        this.usertype = usertype;
        this.comeform = comeform;
        this.userlevel = userlevel;
        this.orgId = orgId;
        this.jobtitleId = jobtitleId;
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "SearchUserResult{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", usertype='" + usertype + '\'' +
                ", comeform=" + comeform +
                ", userlevel=" + userlevel +
                ", orgId=" + orgId +
                ", jobtitleId=" + jobtitleId +
                ", create_time='" + create_time + '\'' +
                '}';
    }
}
