package com.gy.upms.dto.role;

import com.gy.upms.dto.InPage;
import com.gy.upms.dto.UserSecurity;
import com.gy.upms.validation.EnumValidAnnotation;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @ClassName SearchRole.java
 * @Author guofeng
 * @Description
 * @Version 1.0.0
 * @Date 2019年09月02日 17:31:00
 */
public class SearchRole implements Serializable {

    private static final long serialVersionUID = 124743978125382606L;
    @EnumValidAnnotation(value = RoleEnum.RoleStatus.class,inputMethod = "getStatus",message = "{role.status.notNull}")
    private  Integer status;
    private String roleName;
    @Valid
    @NotNull(message = "{page.notNull}")
    private InPage page;

    @NotNull(message = "{user.security.notNull}")
    @Valid
    private UserSecurity userSecurity;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
