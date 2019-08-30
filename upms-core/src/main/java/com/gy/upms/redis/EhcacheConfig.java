package com.gy.upms.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;

import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.cache.Caching;
import javax.cache.spi.CachingProvider;
import java.io.IOException;
import java.net.URI;


/**
 * @Auther: guofeng
 * @Date: 2019/7/1 18:00
 * @Description: Ehcache 3.x jsr-107接口
 */
@Configuration
public class EhcacheConfig extends CachingConfigurerSupport {

    //spring解析资源文件
    private static final ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();

    private String ehcacheConfig;
    @Value("${spring.cache.jcache.config}")
    public void setEhcacheConfig(String ehcacheConfig) {
        this.ehcacheConfig = ehcacheConfig;
    }

    @Bean
    public CacheManager jCacheCacheManager() throws  IOException {
        //将CachingProvider转换为Ehcache特定的实现org.ehcache.jsr107.EhcacheCachingProvider
        CachingProvider cachingProvider = Caching.getCachingProvider();
        //加载配置文件 获取jsr-107 cacheManager
//        javax.cache.CacheManager cacheManager=cachingProvider.getCacheManager(getClass().getResource("/ehcache.xml").toURI()
//                ,getClass().getClassLoader());

        //转换配置文件为URI
        URI uri= resourceResolver.getResources(this.ehcacheConfig)[0].getURI();
        //获取 cacheManager
        javax.cache.CacheManager cacheManager=cachingProvider
                .getCacheManager(uri,getClass().getClassLoader());

        //转换spring 的jCacheCacheManager

        return new JCacheCacheManager(cacheManager);
    }
}
