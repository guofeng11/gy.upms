package com.gy.upms.dao;

import com.gy.upms.entity.Address;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressMapper {
    int deleteByPrimaryKey(String code);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
}