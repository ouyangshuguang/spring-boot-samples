package com.example.demo.config;

import net.sf.ehcache.CacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheFactoryBean;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class EhCacheConfig {

    @Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactory() {
        Resource resource = new ClassPathResource("config/ehcache.xml");
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        ehCacheManagerFactoryBean.setConfigLocation(resource);
        return ehCacheManagerFactoryBean;
    }

    @Bean
    public EhCacheCacheManager initCache(EhCacheManagerFactoryBean ehCacheManagerFactory) {
        EhCacheCacheManager ehCacheCacheManager = new EhCacheCacheManager();
        ehCacheCacheManager.setCacheManager(ehCacheManagerFactory.getObject());
        return ehCacheCacheManager;
    }

    @Bean(name = "custom")
    public EhCacheFactoryBean ehCacheManagerFactoryBean(CacheManager ehCacheManager) {
        EhCacheFactoryBean ehCacheFactoryBean = new EhCacheFactoryBean();
        ehCacheFactoryBean.setCacheManager(ehCacheManager);
        ehCacheFactoryBean.setCacheName("custom");
        return ehCacheFactoryBean;
    }
}
