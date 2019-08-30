package com.gy.upms.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * @Author: guofeng
 * @Date: 2019/5/28 15:17
 * @Description:
 */
public class ListenerConfig {

    @Autowired
    private LogListener logListener;

    @Bean
    public ServletListenerRegistrationBean listenerRegistrationBean(){
        ServletListenerRegistrationBean servletListenerRegistrationBean=new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(logListener);
        servletListenerRegistrationBean.setOrder(ServletListenerRegistrationBean.HIGHEST_PRECEDENCE+1);
        return  servletListenerRegistrationBean;
    }
}
