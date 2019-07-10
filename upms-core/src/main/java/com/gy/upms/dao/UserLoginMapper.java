package com.gy.upms.dao;

import com.gy.upms.entity.UserLogin;
import com.gy.upms.entity.UserLoginInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
@Mapper
public interface UserLoginMapper {
    int insert(UserLogin record);

    /**
     * c不存在插入 存在更新
     * @param record 要操作的记录
     * @return 受影响的行数
     */
    int insertOrUpdate(UserLogin record);

    int insertSelective(UserLogin record);

    /**
     * 获取用户登录信息
     * @param userId 用户编号
     * @param nowTime 当前时间
     * @return
     */
    UserLoginInfo selectLogin(@Param("userId") int userId,@Param("nowTime") LocalDateTime nowTime);
}