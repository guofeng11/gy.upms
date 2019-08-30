package com.gy.upms.dto.organization;

import com.gy.upms.dto.UserSecurity;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @ClassName EditOrg.java
 * @Author guofeng
 * @Description
 * @Version 1.0.0
 * @Date 2019年08月26日 13:34:00
 */
public class EditOrg implements Serializable {
    private static final long serialVersionUID = -8939961042769051975L;

    @NotEmpty(message = "{organization.id.notNull}")
    private Integer id;

    private String orgCode;

    private String orgNameCn;

    private String orgNameEn;

    private String abbrNameCn;

    private String abbrNameEn;
    private String orgType;

    private String creater;
    private String remark;

    @NotNull(message = "{user.security.notNull}")
    @Valid
    private UserSecurity userSecurity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgNameCn() {
        return orgNameCn;
    }

    public void setOrgNameCn(String orgNameCn) {
        this.orgNameCn = orgNameCn;
    }

    public String getOrgNameEn() {
        return orgNameEn;
    }

    public void setOrgNameEn(String orgNameEn) {
        this.orgNameEn = orgNameEn;
    }

    public String getAbbrNameCn() {
        return abbrNameCn;
    }

    public void setAbbrNameCn(String abbrNameCn) {
        this.abbrNameCn = abbrNameCn;
    }

    public String getAbbrNameEn() {
        return abbrNameEn;
    }

    public void setAbbrNameEn(String abbrNameEn) {
        this.abbrNameEn = abbrNameEn;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public UserSecurity getUserSecurity() {
        return userSecurity;
    }

    public void setUserSecurity(UserSecurity userSecurity) {
        this.userSecurity = userSecurity;
    }
}
