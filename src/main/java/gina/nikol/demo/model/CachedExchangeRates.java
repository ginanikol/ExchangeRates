package gina.nikol.demo.model;

import java.time.LocalTime;

public class CachedExchangeRates {

	private LocalTime entryTime;
	private ExchangeRates exchangeRates;

	public CachedExchangeRates(ExchangeRates exchangeRates) {
		this.exchangeRates = exchangeRates;
		this.entryTime = LocalTime.now();
	}
	
	public LocalTime getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(LocalTime entryTime) {
		this.entryTime = entryTime;
	}

	public ExchangeRates getExchangeRates() {
		return exchangeRates;
	}

	public void setExchangeRates(ExchangeRates exchangeRates) {
		this.exchangeRates = exchangeRates;
	}

}
