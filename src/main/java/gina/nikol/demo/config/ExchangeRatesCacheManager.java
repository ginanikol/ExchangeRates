package gina.nikol.demo.config;

import java.time.Duration;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;

import gina.nikol.demo.model.CachedExchangeRates;
import gina.nikol.demo.model.ExchangeRates;

public class ExchangeRatesCacheManager {

	@Autowired
	CacheConfig cacheConfig;

	private static final int CACHE_DURATION_IN_SECONDS = 60;
	
	public ExchangeRates getExchangedRates(String base) {
		Cache cache = cacheConfig.cacheManager().getCache("rates");
		
		if (cache.get(base) != null && cache.get(base).get() instanceof CachedExchangeRates) {
			CachedExchangeRates cachedExchangedRates = (CachedExchangeRates) cache.get(base).get();

			LocalTime currentTime = LocalTime.now();
			long difference = Math.abs(Duration.between(currentTime, cachedExchangedRates.getEntryTime()).getSeconds());

			if (difference <= CACHE_DURATION_IN_SECONDS) {
				return cachedExchangedRates.getExchangeRates();
			}
		}
		return null;
	}
	
	public void setExchangeRates(String base, ExchangeRates exchangeRates) {
		Cache cache = cacheConfig.cacheManager().getCache("rates");
		cache.put(base, new CachedExchangeRates(exchangeRates));
	}

}
