package com.gy.upms.dao;

import com.gy.upms.entity.ServerLog;

public interface ServerLogMapper {
    int deleteByPrimaryKey(String id);

    int insert(ServerLog record);

    int insertSelective(ServerLog record);

    ServerLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ServerLog record);

    int updateByPrimaryKey(ServerLog record);
}