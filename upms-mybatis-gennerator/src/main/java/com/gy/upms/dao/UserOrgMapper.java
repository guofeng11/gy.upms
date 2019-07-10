package com.gy.upms.dao;

import com.gy.upms.entity.UserOrg;

public interface UserOrgMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserOrg record);

    int insertSelective(UserOrg record);

    UserOrg selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserOrg record);

    int updateByPrimaryKey(UserOrg record);
}