package com.gy.upms.dao;

import com.gy.upms.entity.UserAccount;
import com.gy.upms.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);


    int    deleteByRoleId(Integer roleId);
    List<UserRole> selectByRoleId(Integer roleId);
    List<UserAccount> selectByRoleIdForUserAccount(Integer roleId);
    int bulkInsert(@Param("records") List<UserRole> records);
    int bulkDeleteByKey(@Param("records") List<String> ids);
}