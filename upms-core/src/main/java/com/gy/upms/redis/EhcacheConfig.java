package com.gy.upms.redis;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;

import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.cache.Caching;
import javax.cache.spi.CachingProvider;
import java.net.URISyntaxException;

/**
 * @Auther: guofeng
 * @Date: 2019/7/1 18:00
 * @Description: Ehcache 3.x jsr-107接口
 */
@Configuration
public class EhcacheConfig extends CachingConfigurerSupport {

    @Bean
    public CacheManager jCacheCacheManager() throws URISyntaxException {
        //将CachingProvider转换为Ehcache特定的实现org.ehcache.jsr107.EhcacheCachingProvider
        CachingProvider cachingProvider = Caching.getCachingProvider();
        //加载配置文件 获取jsr-107 cacheManager
        javax.cache.CacheManager cacheManager=cachingProvider.getCacheManager(getClass().getResource("/ehcache.xml").toURI()
                ,getClass().getClassLoader());

        //转换spring 的jCacheCacheManager
        JCacheCacheManager jCacheCacheManager=new JCacheCacheManager(cacheManager);

        return  jCacheCacheManager;
    }
}
