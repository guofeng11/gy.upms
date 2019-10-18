package com.gy.upms.redis;

import com.gy.upms.component.JacksonUtils;
import com.gy.upms.entity.UserAccount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @ClassName RedisUtilTest.java
 * @Author guofeng
 * @Description
 * @Version 1.0.0
 * @Date 2019年10月17日 13:43:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisUtilTest {


    @Test
    public void set() {
        UserAccount userAccount=new UserAccount();
        userAccount.setUsername("李强1");
        userAccount.setCreatetime(LocalDateTime.now());
        List<UserAccount> userAccounts=new ArrayList<>();
        userAccounts.add(userAccount);
        RedisUtil.set("test1",userAccounts,5);
        System.out.println(userAccounts);
        List<UserAccount> userObject= JacksonUtils.json2list(RedisUtil.get("test1"),UserAccount.class);
        System.out.println(userObject);
    }




    @Test
    public void hashSet() {
        Map<String,Object> hashMap=new HashMap<>();
        hashMap.put("age",10L);
        hashMap.put("user",1L);
        if(RedisUtil.hasKey("hashtest")){
            RedisUtil.del("hashtest");
        }
        RedisUtil.hashSet("hashtest", hashMap,5);
        RedisUtil.hashSet("hashtest", "name","xx");
        Long userL=((Number) RedisUtil.hashGet("hashtest","user")).longValue();
        System.out.println(userL);
        Map<Object,Object> hashMapResult= RedisUtil.hashGet("hashtest");
        System.out.println(hashMapResult);
    }


    @Test
    public void setSet() {
        RedisUtil.setSetAndTime("settest",5L, "name","xx",5);
        Set<Object> hashSetResult=RedisUtil.setGet("hashtest");

        System.out.println(hashSetResult);
    }




    @Test
    public void listSet() {
        RedisUtil.listSet("listtest","您好",5);
        Long listtestResult= RedisUtil.listGetListSize("listtest");
        System.out.println(listtestResult);
    }


}