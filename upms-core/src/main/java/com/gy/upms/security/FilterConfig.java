package com.gy.upms.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: guofeng
 * @Date: 2019/5/23 10:44
 * @Description:
 */
@Configuration
public class FilterConfig {

    @Autowired
    private ServerAuthenticationFilter serverAuthenticationFilter;
    @Bean
    public FilterRegistrationBean filterRegistration() {
        //新建过滤器注册类
        FilterRegistrationBean registration = new FilterRegistrationBean();
        // 过滤器
        registration.setFilter(serverAuthenticationFilter);
        registration.setName("serverFilter");
        //过滤器顺序
        registration.setOrder(FilterRegistrationBean.HIGHEST_PRECEDENCE+1);
        // 设置过滤器的URL模式
        registration.addUrlPatterns("/*");

        return registration;
    }
}
