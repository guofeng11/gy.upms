package com.gy.upms.dto.role;

import com.gy.upms.dto.UserSecurity;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @ClassName EditRole.java
 * @Author guofeng
 * @Description
 * @Version 1.0.0
 * @Date 2019年09月02日 15:36:00
 */
public class EditRole implements Serializable {

    private static final long serialVersionUID = -8391050397188096171L;
    @Min(value =1 ,message = "{role.id.notNull}")
    private  Integer id;
    @NotEmpty(message = "{role.name.zh.notNull}")
    private String roleName;
    @NotEmpty(message = "{role.name.en.notNull}")
    private String roleNameEn;
    @Min(value = 1,message = "{role.sort.notNull}")
    private Integer sortOrder;


    private String remark;

    private String creater;

    @NotNull(message = "{user.security.notNull}")
    @Valid
    private UserSecurity userSecurity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleNameEn() {
        return roleNameEn;
    }

    public void setRoleNameEn(String roleNameEn) {
        this.roleNameEn = roleNameEn;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
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
