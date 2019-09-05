package com.gy.upms.services;

import com.gy.upms.dto.PageResult;
import com.gy.upms.dto.ResultMessage;
import com.gy.upms.dto.permission.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

/**
 * @Auther: guofeng
 * @Date: 2019/6/10 13:53
 * @Description:
 */
@Validated
public interface PermissionService {

    ResultMessage<String> add(@Valid AddPermission data);
    ResultMessage<String> delete(@Valid DeletePermission data);
    ResultMessage<String> edit(@Valid EditPermission data);
    ResultMessage<DetailPermissionResult> detail(@Valid DetailPermission data);
    ResultMessage<PageResult<SearchPermissionResult>> search(SearchPermission data);
    /**
     * 获取用户权限信息
     * @param userPermission
     * @return 用户权限key集合
     */
    ResultMessage<UserPermissionResult> getUserPermission(@Valid UserPermission userPermission);
}
