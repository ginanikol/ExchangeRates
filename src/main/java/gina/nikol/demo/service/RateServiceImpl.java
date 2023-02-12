package gina.nikol.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import gina.nikol.demo.model.ConversionRate;
import gina.nikol.demo.model.ExchangeRates;

@Service
public class RateServiceImpl implements RatesService {
	
	/**
	 * Parses the ExchangeRates response object 
	 *
	 * @param response the ExchangeRates response to be parsed
	 * @return a new ExchangeRates object with the same data as the response
	 */
	@Override
	public ExchangeRates parseRatesResponse(ExchangeRates response) {

		// do stuff with the response

		return response;

	}


	/**
	 * Parses a list of ConversionRate response objects s
	 *
	 * @param response the list of ConversionRate responses to be parsed
	 * @return a new list of ConversionRate objects with the same data as the response
	 * 
	 */
	@Override
	public List<ConversionRate> parseConversionsResponse(List<ConversionRate> response) {

		// do stuff with the response
		
		return response;
	}

}
