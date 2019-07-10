package com.gy.upms.dao;

import com.gy.upms.entity.JobTitle;

public interface JobTitleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JobTitle record);

    int insertSelective(JobTitle record);

    JobTitle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JobTitle record);

    int updateByPrimaryKey(JobTitle record);
}