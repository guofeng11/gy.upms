package com.gy.upms.dao;

import com.gy.upms.entity.Organization;

public interface OrganizationMapper {
    int deleteByPrimaryKey(Integer orgId);

    int insert(Organization record);

    int insertSelective(Organization record);

    Organization selectByPrimaryKey(Integer orgId);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKeyWithBLOBs(Organization record);

    int updateByPrimaryKey(Organization record);
}