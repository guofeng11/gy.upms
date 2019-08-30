package com.gy.upms.dao;

import com.gy.upms.entity.AppAuthorized;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @ClassName AppAuthorizedMapperTest.java
 * @Author guofeng
 * @Description
 * @Version 1.0.0
 * @Date 2019年08月23日 10:26:00
 */
@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AppAuthorizedMapperTest {

    @Autowired
    private AppAuthorizedMapper appAuthorizedMapper;

    @Test
    public void select() {
        List<AppAuthorized> appAuthorizeds=appAuthorizedMapper.select(1,null);
        appAuthorizeds.stream().forEach(a->{
            System.out.println(a.toString());
        });
    }

    @Test
    public void delete() {
        List<String> ids= new ArrayList<>();
        ids.add("1");
        int result=  appAuthorizedMapper.delete(ids);
        Assert.assertTrue(result==0);
    }
    @Test
    public void bulk(){
        List<AppAuthorized> appAuthorizeds=new ArrayList<>();
        appAuthorizeds.add(new AppAuthorized(1,2,1));
        appAuthorizeds.add(new AppAuthorized(1,2,2));
        appAuthorizeds.add(new AppAuthorized(1,2,3));
        appAuthorizeds.add(new AppAuthorized(1,2,4));
        appAuthorizeds.add(new AppAuthorized(1,2,5));
        appAuthorizedMapper.bulkInsert(appAuthorizeds);
    }
}