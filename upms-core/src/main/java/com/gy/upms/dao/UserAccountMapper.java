package com.gy.upms.dao;

import com.gy.upms.entity.Pageing;
import com.gy.upms.entity.UserAccount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserAccount record);

    int insertSelective(UserAccount record);

    UserAccount selectByPrimaryKey(Integer id);

    /**
     *
     * @param record
     * @param offset 跳过行数 (currentPage-1)*pageSize
     * @param rows 行数
     * @return
     */
    Pageing<UserAccount> selectByPage(@Param("record")UserAccount record, @Param("offset")int offset, @Param("rows")int rows);

    int updateByPrimaryKeySelective(UserAccount record);

    int updateByPrimaryKey(UserAccount record);

    UserAccount login(@Param("username") String userName,@Param("password")String pwd);

    /**
     * 验证用户是否存在 用户名 手机 邮箱不可以重复
     * @param userName
     * @param phone
     * @param email
     * @return
     */
    int countUser(@Param("username")String userName,@Param("phone")String phone,@Param("email")String email);
    int bulkDelete(@Param("ids") List<Integer> ids);
}