package com.gy.upms.dto.role;

import java.io.Serializable;

/**
 * @ClassName SearchRoleResult.java
 * @Author guofeng
 * @Description
 * @Version 1.0.0
 * @Date 2019年09月02日 17:33:00
 */
public class SearchRoleResult implements Serializable {
    private static final long serialVersionUID = 985027410159876160L;
    private Integer id;

    private String roleName;

    private String roleNameEn;

    private Integer sortOrder;

    private Integer status;

    public SearchRoleResult() {
    }

    public SearchRoleResult(Integer id, String roleName, String roleNameEn, Integer sortOrder, Integer status) {
        this.id = id;
        this.roleName = roleName;
        this.roleNameEn = roleNameEn;
        this.sortOrder = sortOrder;
        this.status = status;
    }

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
