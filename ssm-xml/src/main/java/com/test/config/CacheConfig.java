package com.test.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
@EnableCaching
public class CacheConfig {
    @Bean
    public CacheManager cacheManager() throws IOException {
        ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager("cache1");
//        RedissonSpringCacheManager cacheManager = new RedissonSpringCacheManager(redissonClient());
        return cacheManager;
    }
//    @Bean
//    public RedissonClient redissonClient() throws IOException {
//        File file = ResourceUtils.getFile("classpath:redis.yml");
//        InputStream inputStream = new FileInputStream(file);
////        ClassPathResource classPathResource = new ClassPathResource("redis.yml");
////        InputStream inputStream = classPathResource.getInputStream();
////        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("redis.yml");
//        Config config = Config.fromYAML(inputStream);
//        return Redisson.create(config);
//    }
}
