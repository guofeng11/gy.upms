package com.gy.upms.dao;


import com.gy.upms.component.JacksonUtils;
import com.gy.upms.component.VerifyUtils;
import com.gy.upms.entity.AppAndAuthInfo;
import com.gy.upms.entity.AppAuthInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Auther: guofeng
 * @Date: 2019/6/14 11:55
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationMapperTest {

    @Autowired
    private ApplicationMapper applicationMapper;
    @Test
    public void selectByToken() {


        AppAndAuthInfo appAuthInfo=applicationMapper.selectByToken("123456");
        System.out.println(appAuthInfo);
        System.out.println( JacksonUtils.obj2json(appAuthInfo));
    }
}
