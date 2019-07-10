package com.gy.upms.dao;

import com.gy.upms.entity.AppAuthorized;

public interface AppAuthorizedMapper {
    int deleteByPrimaryKey(String id);

    int insert(AppAuthorized record);

    int insertSelective(AppAuthorized record);

    AppAuthorized selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AppAuthorized record);

    int updateByPrimaryKey(AppAuthorized record);
}