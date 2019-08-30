package com.gy.upms.dto.organization;

import com.gy.upms.dto.UserSecurity;
import com.gy.upms.validation.EnumValidAnnotation;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @ClassName AddOrg.java
 * @Author guofeng
 * @Description
 * @Version 1.0.0
 * @Date 2019年08月26日 09:46:00
 */
public class AddOrg implements Serializable {
    private static final long serialVersionUID = -7924521775907483651L;

    @NotEmpty(message = "{organization.code.notNull}")
    private String orgCode;
    @NotEmpty(message = "{organization.name.zh.notNull}")
    private String orgNameCn;
    @NotEmpty(message = "{organization.name.en.notNull}")
    private String orgNameEn;
    @NotEmpty(message = "{organization.abbrName.zh.notNull}")
    private String abbrNameCn;
    @NotEmpty(message = "{organization.abbrName.en.notNull}")
    private String abbrNameEn;

    @NotEmpty(message = "{organization.type.notNull}")
    @EnumValidAnnotation(value = OrganizationEnum.OrganizationType.class,inputMethod = "getTypeCode",message = "{organization.type.notNull}")
    private String orgType;

    @Min(value = 1,message = "{organization.level.notNull}")
    private Integer level;
    @Min(value = 0,message = "{organization.parent.notNull}")
    private Integer parentId;

    private String creater;
    private String remark;

    @NotNull(message = "{user.security.notNull}")
    @Valid
    private UserSecurity userSecurity;

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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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
