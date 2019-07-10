package com.gy.upms.dao;

import com.gy.upms.entity.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKeyWithBLOBs(Role record);

    int updateByPrimaryKey(Role record);
}