package com.test.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

@Configuration
@EnableCaching
public class CacheConfig {
    @Bean("hashCache")
    public CacheManager cacheManager() {
        ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager("cache1");
        return cacheManager;
    }

    @Bean("redisCache")
    public CacheManager cacheManager1() throws IOException {
        RedissonSpringCacheManager cacheManager = new RedissonSpringCacheManager(redissonClient());
        cacheManager.setCacheNames(Arrays.asList("redisCache"));
        return cacheManager;
    }
    @Bean
    public RedissonClient redissonClient() throws IOException {
        File file = ResourceUtils.getFile("classpath:redis.yml");
        InputStream inputStream = new FileInputStream(file);
//        ClassPathResource classPathResource = new ClassPathResource("redis.yml");
//        InputStream inputStream = classPathResource.getInputStream();
//        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("redis.yml");
        Config config = Config.fromYAML(inputStream);
        return Redisson.create(config);
    }
}
