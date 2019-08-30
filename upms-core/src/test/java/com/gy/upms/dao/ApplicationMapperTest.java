package com.gy.upms.dao;


import com.gy.upms.dto.application.ApplicationEnum;
import com.gy.upms.entity.AppAndAuthInfo;
import com.gy.upms.entity.Application;
import com.gy.upms.entity.Pageing;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @Auther: guofeng
 * @Date: 2019/6/14 11:55
 * @Description:
 */
@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)//真实数据源
public class ApplicationMapperTest {

    @Autowired
    private ApplicationMapper applicationMapper;
    @Test
    public void selectByToken() {
        AppAndAuthInfo appAuthInfo=applicationMapper.selectByToken("2a0417a1-7303-44f8-896b-108ab153b6f1");
        Assert.assertFalse("令牌不存在",appAuthInfo==null);
    }

    @Test
    public void selectByPage() {
        Application application=new Application();
        application.setAppName("app2");
        Pageing<Application> applicationPageing= applicationMapper.selectByPage(application,0,10);
    }

    @Test
//    @Rollback(false)
    public void insertSelective() {
        Application application=new Application();
        application.setAppName("app2");
        application.setAppNameEn("app2");
        application.setAppToken(UUID.randomUUID().toString());
        application.setCreater("admin");
        application.setCreaterId(1);
        application.setIpv4("127.0.0.2");
        application.setStatus(ApplicationEnum.ApplicationStatus.NORMAL.getStatus());
        application.setRemark("no insert");
        application.setCreateTime(LocalDateTime.now());
        int result= applicationMapper.insert(application);
        Assert.assertEquals(result,1);
    }
}
