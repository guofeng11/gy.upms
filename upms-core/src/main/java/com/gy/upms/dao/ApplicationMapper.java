package com.gy.upms.dao;

import com.gy.upms.entity.AppAndAuthInfo;
import com.gy.upms.entity.AppAuthInfo;
import com.gy.upms.entity.Application;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ApplicationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Application record);

    int insertSelective(Application record);

    Application selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Application record);

    int updateByPrimaryKey(Application record);

    /**
     * 根据app id 获取收取应用的信息
     * @param id 应用程序编号
     * @return 返回状态正常的应用
     */
    List<AppAuthInfo> selectAuthById(Integer id);
    /**
     * 根据token 获取app 及授权 app
     * @param token app 的应用令牌
     * @return 返回状态正常的应用
     */
    AppAndAuthInfo selectByToken(@Param("token") String token);
}