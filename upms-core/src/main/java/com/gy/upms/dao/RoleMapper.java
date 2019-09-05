package com.gy.upms.dao;

import com.gy.upms.entity.Pageing;
import com.gy.upms.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    List<Role> select(Role record);
    /**
     * 分页查询
     * 中文、英文名称统一 模糊匹配 即 输入中文名 也查询匹配的英文名称
     * @param record
     * @param offset
     * @param rows
     * @return
     */
    Pageing<Role> selectByPage(@Param("record")Role record, @Param("offset")int offset, @Param("rows")int rows);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKeyWithBLOBs(Role record);

    int updateByPrimaryKey(Role record);
}