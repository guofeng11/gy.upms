package com.gy.upms.services;


import com.gy.upms.dto.PageResult;
import com.gy.upms.dto.ResultMessage;
import com.gy.upms.dto.user.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

/**
 * @Auther: guofeng
 * @Date: 2019/4/25 14:43
 * @Description:
 */
@Validated
public interface UserService {
    /**
     * 登录
     * @param login 登录参数
     * @return 登录后令牌等信息
     */
    ResultMessage<LoginResult> login(@Valid Login login, String userType);

    /**
     * 用户注册
     * @param register 注册信息
     * @return 返回注册结构 成功注册后 返回token
     */
    ResultMessage<RegisterResult> register(@Valid Register register);

    /**
     * 添加用户 需要身份验证
     * @param addUser 要添加的用户信息
     * @return 成功返回添加的用户
     */
    ResultMessage<AddUserResult> add(@Valid AddUser addUser);

    /**
     * 查询用户列表
     * @param searchUser  查询参数
     * @return 用户信息
     */
    ResultMessage<PageResult<SearchUserResult>>search(@Valid SearchUser searchUser);

    /**
     * s删除用户
     * @param deleteUser 删除参数
     * @return 是否成功删除
     */
    ResultMessage<String>delete(@Valid DeleteUser deleteUser);

    /**
     * 用户详情
     * @param detailUser  用户详情参数
     * @return 用户基础信息
     */
    ResultMessage<DetailUserResult>detail(@Valid DetailUser detailUser);
}
