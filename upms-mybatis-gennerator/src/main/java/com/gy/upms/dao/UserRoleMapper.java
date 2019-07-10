package com.gy.upms.dao;

import com.gy.upms.entity.UserRole;

public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);
}