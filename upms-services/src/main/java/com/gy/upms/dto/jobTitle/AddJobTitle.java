package com.gy.upms.dto.jobTitle;

import com.gy.upms.dto.UserSecurity;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @ClassName AddJobTitle.java
 * @Author guofeng
 * @Description
 * @Version 1.0.0
 * @Date 2019年09月03日 13:59:00
 */
public class AddJobTitle implements Serializable {

    private static final long serialVersionUID = -7273815272732334898L;
    @NotEmpty(message = "{jobTitle.name.zh.notNull}")
    private String jobTitle;
    @NotEmpty(message = "{jobTitle.name.cn.notNull}")
    private String jobTitleEn;
    @Min(value = 1,message = "{jobTitle.level.notNull}")
    private Integer level;

    private String remark;

    private String creater;

    @NotNull(message = "{user.security.notNull}")
    @Valid
    private UserSecurity userSecurity;

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobTitleEn() {
        return jobTitleEn;
    }

    public void setJobTitleEn(String jobTitleEn) {
        this.jobTitleEn = jobTitleEn;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public UserSecurity getUserSecurity() {
        return userSecurity;
    }

    public void setUserSecurity(UserSecurity userSecurity) {
        this.userSecurity = userSecurity;
    }
}
