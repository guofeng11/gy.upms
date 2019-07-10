package com.gy.upms.dao;

import com.gy.upms.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    /**
     * 获取用户权限
     * @param userId 用户编号
     * @param appId 对应的应用程序编号
     * @return 权限列表
     */
    List<Permission> selectByUserIdAndAppId(@Param("userId") Integer userId, @Param("appId") Integer appId);
    List<Permission> selectByAppToken(@Param("token") String appToken);
}