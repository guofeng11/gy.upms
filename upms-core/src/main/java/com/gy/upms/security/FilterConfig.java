package com.gy.upms.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: guofeng
 * @Date: 2019/5/23 10:44
 * @Description:
 */
@Configuration
public class FilterConfig {

    @Autowired
    private ServerAuthenticationFilter serverAuthenticationFilter;
    @Autowired
    private CORSFilter corsFilter;

    @Bean
    public FilterRegistrationBean corsFilterRegistration() {
        //新建过滤器注册类
        FilterRegistrationBean registration = new FilterRegistrationBean();
        // 过滤器
        registration.setFilter(corsFilter);
        registration.setName("corsFilter");
        //过滤器顺序
        registration.setOrder(FilterRegistrationBean.LOWEST_PRECEDENCE-2);
        // 设置过滤器的URL模式
        registration.addUrlPatterns("/*");

        return registration;
    }
    @Bean
    public FilterRegistrationBean serverAuthenticationFilterRegistration() {
        //新建过滤器注册类
        FilterRegistrationBean registration = new FilterRegistrationBean();
        // 过滤器
        registration.setFilter(serverAuthenticationFilter);
        registration.setName("serverAuthenticationFilter");
        //过滤器顺序
        registration.setOrder(FilterRegistrationBean.LOWEST_PRECEDENCE-1);
        // 设置过滤器的URL模式
        registration.addUrlPatterns("/*");

        return registration;
    }
}
