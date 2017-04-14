package com.fhr.musicstorerest.cache;


import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import net.sf.ehcache.CacheManager;

/**
 * redis cache配置类 
 * @author fhr
 * @date 2017/04/14 
 */

@Configuration
@EnableCaching
public class CachingConfig {
	//Redis连接工厂
	@Bean 
	 public JedisConnectionFactory redisConnectionFactory() { 
	  JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory(); 
	  //设置连接信息
	  redisConnectionFactory.setHostName("101.200.55.205"); 
	  redisConnectionFactory.setPort(6379); 
	  redisConnectionFactory.setPassword("12345678");
	  return redisConnectionFactory; 
	 } 
	 //RedisTemplate 
	 @Bean 
	 public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory cf) { 
	  RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>(); 
	  redisTemplate.setConnectionFactory(cf); 
	  return redisTemplate; 
	 } 
	 //Redis缓存管理器
	 @Bean 
	 public RedisCacheManager cacheManager(RedisTemplate redisTemplate) { 
	  RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate); 
	  cacheManager.setDefaultExpiration(3000); 
	  return cacheManager; 
	 } 
}
