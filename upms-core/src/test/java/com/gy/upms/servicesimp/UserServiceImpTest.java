package com.gy.upms.servicesimp;

import com.gy.upms.dto.InPage;
import com.gy.upms.dto.PageResult;
import com.gy.upms.dto.ResultMessage;
import com.gy.upms.dto.user.Register;
import com.gy.upms.dto.user.RegisterResult;
import com.gy.upms.dto.user.SearchUser;
import com.gy.upms.dto.user.SearchUserResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



/**
 * @Auther: guofeng
 * @Date: 2019/6/3 14:32
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public  class UserServiceImpTest {

    @Autowired
    private  UserServiceImp userServiceImp;

    @Test
    public  void registerTest() {
//        Register register=new Register("admin","admin","123456","admin@test.com","1312345678");
//        ResultMessage<RegisterResult> result= userServiceImp.register(register);
//        System.out.println(result.getResult()+" "+result.getMessage());
    }
    @Test
    public void searchTest(){
        SearchUser searchUser=new SearchUser();
        searchUser.setPhone("131");
        searchUser.setPage(new InPage(1,1));
        ResultMessage<PageResult<SearchUserResult>> resultMessage=userServiceImp.search((searchUser));
    }
}