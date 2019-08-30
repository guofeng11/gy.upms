package com.gy.upms.dao;

import com.gy.upms.entity.AppAuthorized;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AppAuthorizedMapper {
    int deleteByPrimaryKey(String id);

    int insert(AppAuthorized record);

    int insertSelective(AppAuthorized record);

    AppAuthorized selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AppAuthorized record);

    int updateByPrimaryKey(AppAuthorized record);

    /**
     * 查找授权的应用信息
     * @param appId 应用编号
     * @param authAppId 授权应用编号
     * @return
     */
    List<AppAuthorized> select(@Param("appId") Integer appId,@Param("authAppId") Integer authAppId);

    /**
     * 批量删除
     * @param ids 授权主键
     * @return
     */
    int delete(@Param("ids") List<String> ids);

    /**
     * 批量插入
     * @param auApps id不输入
     * @return
     */
    int bulkInsert(@Param("authApps") List<AppAuthorized> auApps);
}