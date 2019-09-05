package com.gy.upms.dao;

import com.gy.upms.entity.JobTitle;
import com.gy.upms.entity.Pageing;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface JobTitleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JobTitle record);

    int insertSelective(JobTitle record);

    JobTitle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JobTitle record);

    int updateByPrimaryKey(JobTitle record);

    List<JobTitle> select(JobTitle record);
    /**
     * 分页查询
     * 中文、英文名称统一 模糊匹配 即 输入中文名 也查询匹配的英文名称
     * @param record
     * @param offset
     * @param rows
     * @return
     */
    Pageing<JobTitle> selectByPage(@Param("record")JobTitle record, @Param("offset")int offset, @Param("rows")int rows);
}