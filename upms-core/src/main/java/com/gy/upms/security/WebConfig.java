package com.gy.upms.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther: guofeng
 * @Date: 2019/5/16 14:16
 * @Description:
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Autowired
    private UserAuthenticationInterceptor userAuthenticationInterceptor;
    /**
     * 跨域配置
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("PUT", "DELETE","GET","POST")
                .allowedHeaders("Authorization", "Content-Type", "Accept")
               // .exposedHeaders("header1", "header2") 不允许的header
                .allowCredentials(true)
                .maxAge(86400);//缓存时间秒

        // Add more mappings...
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        // RequestInterceptor()为自己定义的拦截器
        registry.addInterceptor(userAuthenticationInterceptor).addPathPatterns("/**");
    }

}
