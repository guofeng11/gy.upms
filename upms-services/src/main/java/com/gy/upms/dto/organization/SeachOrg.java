package com.gy.upms.dto.organization;

import com.gy.upms.dto.InPage;
import com.gy.upms.dto.UserSecurity;
import com.gy.upms.validation.EnumValidAnnotation;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


/**
 * @ClassName SeachOrg.java
 * @Author guofeng
 * @Description
 * @Version 1.0.0
 * @Date 2019年08月26日 13:51:00
 */
public class SeachOrg implements Serializable {
    private static final long serialVersionUID = 6197425485598829967L;
    private String orgCode;
    @EnumValidAnnotation(value = OrganizationEnum.OrganizationType.class,inputMethod = "getTypeCode",message = "{organization.type.notNull}")
    private String orgType;
    private String orgName;
    private Integer level;
    @Valid
    @NotNull(message = "{page.notNull}")
    private InPage page;

    @NotNull(message = "{user.security.notNull}")
    @Valid
    private UserSecurity userSecurity;

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public InPage getPage() {
        return page;
    }

    public void setPage(InPage page) {
        this.page = page;
    }

    public UserSecurity getUserSecurity() {
        return userSecurity;
    }

    public void setUserSecurity(UserSecurity userSecurity) {
        this.userSecurity = userSecurity;
    }
}
