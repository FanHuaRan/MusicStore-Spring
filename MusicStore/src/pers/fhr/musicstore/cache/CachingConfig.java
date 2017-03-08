package pers.fhr.musicstore.cache;


import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import net.sf.ehcache.CacheManager;

/**
 * EhCache配置类 
 * @author ASUS
 *
 */

@Configuration
@EnableCaching
public class CachingConfig {
	//缓存管理器
	@Bean
	public EhCacheCacheManager cacheManager(CacheManager cm){
		return new EhCacheCacheManager(cm);
	}
	//工厂bean
	@Bean
	public EhCacheManagerFactoryBean ehcache(){
		EhCacheManagerFactoryBean ehCacheManagerFactoryBean=new EhCacheManagerFactoryBean();
		ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("pers/fhr/musicstore/cache/ehcache.xml"));
		return ehCacheManagerFactoryBean;
	}
}
