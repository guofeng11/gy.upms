package com.gy.upms.dao;

import com.gy.upms.entity.Organization;
import com.gy.upms.entity.Pageing;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrganizationMapper {
    int deleteByPrimaryKey(Integer orgId);

    int insert(Organization record);

    int insertSelective(Organization record);

    Organization selectByPrimaryKey(Integer orgId);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKeyWithBLOBs(Organization record);

    int updateByPrimaryKey(Organization record);

    List<Organization> select(Organization record);

    Pageing<Organization> selectByPage(@Param("record")Organization record, @Param("offset")int offset, @Param("rows")int rows);
}