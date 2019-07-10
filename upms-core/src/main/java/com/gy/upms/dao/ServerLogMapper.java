package com.gy.upms.dao;

import com.gy.upms.entity.ServerLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ServerLogMapper {
    int deleteByPrimaryKey(String id);

    int insert(ServerLog record);

    int insertSelective(ServerLog record);

    ServerLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ServerLog record);

    int updateByPrimaryKey(ServerLog record);
}