/**
 * 
 */
package com.sun.springboot.caching.config;

import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author SUN
 *
 */
@Configuration
public class CacheConfig {
	
	@Bean
	CacheManagerCustomizer<ConcurrentMapCacheManager> customizer(){
		return new ConcurrentCustomizer();
	}
	
	class ConcurrentCustomizer implements CacheManagerCustomizer<ConcurrentMapCacheManager>{

		@Override
		public void customize(ConcurrentMapCacheManager cacheManager) {
			cacheManager.setAllowNullValues(false);
			cacheManager.setStoreByValue(true);
			System.out.println("Customized invoked....");
			
		}
		
	}

}
