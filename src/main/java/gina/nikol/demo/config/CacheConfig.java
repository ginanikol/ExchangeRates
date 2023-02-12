package gina.nikol.demo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {

  @Bean
  public CacheManager cacheManager() {
    ConcurrentMapCacheManager mgr = new ConcurrentMapCacheManager();
    List<String> cacheNames = new ArrayList<>();
    cacheNames.add("rates");
    mgr.setCacheNames(cacheNames);
    return mgr;
  }
  
	@Bean
	public ExchangeRatesCacheManager exchangeRatesCacheManager() {
		return new ExchangeRatesCacheManager();
	}
}
