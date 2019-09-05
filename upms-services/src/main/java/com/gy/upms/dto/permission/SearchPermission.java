package com.gy.upms.dto.permission;

import com.gy.upms.dto.InPage;
import com.gy.upms.dto.UserSecurity;
import com.gy.upms.validation.EnumValidAnnotation;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @ClassName SearchPermission.java
 * @Author guofeng
 * @Description
 * @Version 1.0.0
 * @Date 2019年08月30日 15:28:00
 */
public class SearchPermission implements Serializable {

    private static final long serialVersionUID = -707600692259152048L;
    @Min(value = 1,message = "{app.id.notNull}")
    private Integer appId;

    private String permKey;

    @EnumValidAnnotation(value = PermissionEnum.PermissionStatus.class,inputMethod = "getStatus",message = "{permission.status.notNull}")
    private Integer status;

    @Min(value = 1,message = "{permission.level.notNull}")
    private Integer level;
    @Min(value = 0,message = "{permission.parent.notNull}")
    private Integer parentId;

    @Valid
    @NotNull(message = "{page.notNull}")
    private InPage page;

    @NotNull(message = "{user.security.notNull}")
    @Valid
    private UserSecurity userSecurity;

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getPermKey() {
        return permKey;
    }

    public void setPermKey(String permKey) {
        this.permKey = permKey;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
