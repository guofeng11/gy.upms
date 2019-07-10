package com.gy.upms.dao;

import com.gy.upms.dto.user.UserEnum;
import com.gy.upms.entity.Pageing;
import com.gy.upms.entity.UserAccount;
import com.gy.upms.redis.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.MessageFormat;

/**
 * @Auther: guofeng
 * @Date: 2019/5/10 14:33
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserAccountMapperTest {

    @Autowired
    private  UserAccountMapper userAccountMapper;

    @Test
    public void loginTest(){
        UserAccount userAccount=userAccountMapper.login("admin","123456");
        if (userAccount!=null){
            System.out.print(userAccount.toString());
        }
        String s= MessageFormat.format("{0},没数据","login");
        System.out.print(s);
    }
    @Test
    public void selectByPageTest(){
        UserAccount userAccount=new UserAccount();
//        userAccount.setId(6);
        userAccount.setPhone("131");
        userAccount.setStatus(UserEnum.UserStatus.NORMAL.getStatus());
        Pageing<UserAccount> userAccountList= userAccountMapper.selectByPage(userAccount,0,1);

        System.out.println(userAccountList.getRows().getTotalRows() +"======"+ userAccountList.getRows().getTotalPage());
        for (UserAccount ua:userAccountList.getDataList()){
            System.out.println(ua.toString());
        }
    }
}