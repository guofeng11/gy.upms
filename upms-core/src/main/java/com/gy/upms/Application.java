package com.gy.upms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @Author: guofeng
 * @Date: 2019/5/7 14:58
 * @Description:
 */
@SpringBootApplication
@ServletComponentScan
public class Application {
    private final static Logger log= LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        log.debug("启动开始");
//        SpringApplication.run(Application.class, args);
        SpringApplication springApplication=new SpringApplication(Application.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);

    }
}
