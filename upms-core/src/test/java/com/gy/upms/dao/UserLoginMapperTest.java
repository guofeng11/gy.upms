package com.gy.upms.dao;

import com.gy.upms.component.VerifyUtils;
import com.gy.upms.entity.UserLogin;
import com.gy.upms.entity.UserLoginInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;


/**
 * @Auther: guofeng
 * @Date: 2019/6/4 10:14
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserLoginMapperTest {

    @Autowired
    private  UserLoginMapper userLoginMapper;
    @Test
   public void insertOrUpdate() {
        UserLogin userLogin=new UserLogin();
        userLogin.setUserId(6);
        userLogin.setExpDur(30);
        userLogin.setLoginTime(LocalDateTime.now());
        userLoginMapper.insertOrUpdate(userLogin);
    }
    @Test
    public void selectLoginInfo(){
        UserLoginInfo userLoginInfo= VerifyUtils.getUserLogin(6, LocalDateTime.now());
        System.out.println(userLoginInfo.toString());

    }
}