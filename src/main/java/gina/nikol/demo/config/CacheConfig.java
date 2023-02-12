package gina.nikol.demo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The `CacheConfig` class is a configuration class for caching in the application.
 * It enables caching using the `@EnableCaching` annotation and defines two beans:
 * `cacheManager` and `exchangeRatesCacheManager`.
 */
@Configuration
@EnableCaching
public class CacheConfig {

  /**
   * Defines a bean for a concurrent map cache manager.
   * The cache manager is used to manage the caching of exchange rates data.
   * 
   * @return the cache manager
   */
  @Bean
  public CacheManager cacheManager() {
    ConcurrentMapCacheManager mgr = new ConcurrentMapCacheManager();
    List<String> cacheNames = new ArrayList<>();
    cacheNames.add("rates");
    mgr.setCacheNames(cacheNames);
    return mgr;
  }
  
	/**
	 * Defines a bean for the exchange rates cache manager.
	 * 
	 * @return the exchange rates cache manager
	 */
	@Bean
	public ExchangeRatesCacheManager exchangeRatesCacheManager() {
		return new ExchangeRatesCacheManager();
	}
}

