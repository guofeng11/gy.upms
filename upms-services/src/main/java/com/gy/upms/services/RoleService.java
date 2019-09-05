package com.gy.upms.services;

import com.gy.upms.dto.PageResult;
import com.gy.upms.dto.ResultMessage;
import com.gy.upms.dto.role.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

/**
 * @Auther: guofeng
 * @Date: 2019/6/10 13:54
 * @Description:
 */
@Validated
public interface RoleService {
    ResultMessage<String> add(@Valid AddRole data);
    ResultMessage<String> edit(@Valid EditRole data);
    ResultMessage<DetailRoleResult> detail(@Valid DetailRole data);
    ResultMessage<String> delete(@Valid DeleteRole data);
    ResultMessage<PageResult<SearchRoleResult>> search(@Valid SearchRole data);
    ResultMessage<String> setRoleUser(@Valid SetRoleUser data);
    ResultMessage<List<GetRoleUserResult>> getRoleUser(@Valid GetRoleUser data);
    ResultMessage<String> setRolePerm(@Valid SetRolePerm data);
    ResultMessage<List<GetRolePermResult>> getRolePerm(@Valid GetRolePerm data);
}
