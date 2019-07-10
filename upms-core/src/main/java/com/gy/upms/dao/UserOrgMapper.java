package com.gy.upms.dao;

import com.gy.upms.entity.UserOrg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserOrgMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserOrg record);

    int insertSelective(UserOrg record);

    UserOrg selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserOrg record);

    int updateByPrimaryKey(UserOrg record);

    /**
     * 查找用户的组织 包含创建用户时 组织
     * @param useId 用户编号
     * @return
     */
    List<UserOrg> selectByUserId(@Param("userId") Integer useId);
}