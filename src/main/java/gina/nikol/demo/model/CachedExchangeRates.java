package gina.nikol.demo.model;

import java.time.LocalTime;

/**
 * The `CachedExchangeRates` class represents a cache entry for exchange rates data.
 * It holds the exchange rates data and the time the data was entered into the cache.
 */
public class CachedExchangeRates {

	/**
	 * The time the exchange rates data was entered into the cache.
	 */
	private LocalTime entryTime;

	/**
	 * The exchange rates data.
	 */
	private ExchangeRates exchangeRates;

	/**
	 * Constructs a new `CachedExchangeRates` object with the specified exchange rates data and current time.
	 * 
	 * @param exchangeRates the exchange rates data
	 */
	public CachedExchangeRates(ExchangeRates exchangeRates) {
		this.exchangeRates = exchangeRates;
		this.entryTime = LocalTime.now();
	}
	
	/**
	 * Returns the time the exchange rates data was entered into the cache.
	 * 
	 * @return the time the exchange rates data was entered into the cache
	 */
	public LocalTime getEntryTime() {
		return entryTime;
	}

	/**
	 * Sets the time the exchange rates data was entered into the cache.
	 * 
	 * @param entryTime the time the exchange rates data was entered into the cache
	 */
	public void setEntryTime(LocalTime entryTime) {
		this.entryTime = entryTime;
	}

	/**
	 * Returns the exchange rates data.
	 * 
	 * @return the exchange rates data
	 */
	public ExchangeRates getExchangeRates() {
		return exchangeRates;
	}

	/**
	 * Sets the exchange rates data.
	 * 
	 * @param exchangeRates the exchange rates data
	 */
	public void setExchangeRates(ExchangeRates exchangeRates) {
		this.exchangeRates = exchangeRates;
	}

}

