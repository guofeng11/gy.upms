package com.gy.upms.dao;

import com.gy.upms.Application;
import com.gy.upms.entity.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Auther: guofeng
 * @Date: 2019/5/9 16:06
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class AddressMapperTest {

    @Autowired
    private AddressMapper addressMapper;


    @Test
    public void selectTest(){
        Object i= addressMapper.selectByPrimaryKey("10000");
        System.out.println(i);
    }
}