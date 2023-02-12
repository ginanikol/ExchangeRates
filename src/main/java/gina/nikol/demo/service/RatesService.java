package gina.nikol.demo.service;

import java.util.List;

import gina.nikol.demo.model.ConversionRate;
import gina.nikol.demo.model.ExchangeRates;

/**
 * An interface for services that parse exchange rate and conversion responses.
 */
public interface RatesService {

	public ExchangeRates parseRatesResponse (ExchangeRates response);
	
	public List<ConversionRate> parseConversionsResponse(List<ConversionRate> response);
	
}
