package com.gy.upms.services;

import com.gy.upms.dto.ResultMessage;
import com.gy.upms.dto.permission.UserPermission;
import com.gy.upms.dto.permission.UserPermissionResult;

/**
 * @Auther: guofeng
 * @Date: 2019/6/10 13:53
 * @Description:
 */
public interface PermissionService {

    /**
     * 获取用户权限信息
     * @param userPermission
     * @return 用户权限key集合
     */
    ResultMessage<UserPermissionResult> getUserPermission(UserPermission userPermission);
}
