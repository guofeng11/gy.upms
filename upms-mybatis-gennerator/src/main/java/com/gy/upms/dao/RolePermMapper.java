package com.gy.upms.dao;

import com.gy.upms.entity.RolePerm;

public interface RolePermMapper {
    int insert(RolePerm record);

    int insertSelective(RolePerm record);
}