package com.gy.upms.dao;

import com.gy.upms.entity.Permission;
import com.gy.upms.entity.RolePerm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RolePermMapper {
    int deleteByPrimaryKey(String id);

    int insert(RolePerm record);

    int insertSelective(RolePerm record);

    RolePerm selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RolePerm record);

    int updateByPrimaryKey(RolePerm record);

    int    deleteByRoleId(Integer roleId);
    List<RolePerm> selectByRoleId(Integer roleId);
    List<Permission> selectByRoleIdForPermission(Integer roleId);
    int bulkInsert(@Param("records") List<RolePerm> records);
    int bulkDeleteByKey(@Param("records") List<String> ids);
}