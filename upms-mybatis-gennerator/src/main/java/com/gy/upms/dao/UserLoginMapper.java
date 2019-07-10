package com.gy.upms.dao;

import com.gy.upms.entity.UserLogin;

public interface UserLoginMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserLogin record);

    int insertSelective(UserLogin record);

    UserLogin selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserLogin record);

    int updateByPrimaryKey(UserLogin record);
}