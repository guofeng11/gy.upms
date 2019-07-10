package com.gy.upms.dao;

import com.gy.upms.entity.Address;

public interface AddressMapper {
    int deleteByPrimaryKey(String code);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
}