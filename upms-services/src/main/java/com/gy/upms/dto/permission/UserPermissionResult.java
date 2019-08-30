package com.gy.upms.dto.permission;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName UserPermissionResult.java
 * @Author guofe
 * @Description 用户权限返回
 * @Version 1.0.0
 * @Date 2019年07月25日 14:47:00
 */
public class UserPermissionResult implements Serializable {
    private static final long serialVersionUID = -3748587655572296573L;

    private List<String> permissionKey;

    public List<String> getPermissionKey() {
        return permissionKey;
    }

    public void setPermissionKey(List<String> permissionKey) {
        this.permissionKey = permissionKey;
    }



    @Override
    public String toString() {
        return "UserPermissionResult{" +
                "permissionKey=" + permissionKey +
                '}';
    }
}
