package gina.nikol.demo.rest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import gina.nikol.demo.config.ExchangeRatesCacheManager;
import gina.nikol.demo.model.ConversionRate;
import gina.nikol.demo.model.ExchangeRates;
import gina.nikol.demo.service.RatesService;

@RestController
public class ExchangeRateController {

	@Autowired
	RatesService service;

	@Autowired
	ExchangeRatesCacheManager cacheManager;
	
	/**
	 * REST endpoint for fetching exchange rates
	 *
	 * @param base the base currency to convert from. If not supplied, default is EUR
	 * @return ExchangeRates object containing exchange rates information
	 * 
	 */
	@GetMapping("/rates/latest")
	public ExchangeRates getRates(@RequestParam(value = "base", required = false) String base) {

		String normalizedBase = base != null ? base : "EUR";
		ExchangeRates exchangeRates = cacheManager.getExchangedRates(normalizedBase);
		if(exchangeRates != null) {
			return service.parseRatesResponse(exchangeRates);
		}
		
		RestTemplate restTemplate = new RestTemplate();
		String url = String.format("https://api.exchangerate.host/latest?base=%s", base);
		ExchangeRates rates = restTemplate.getForObject(url, ExchangeRates.class);
		
		cacheManager.setExchangeRates(normalizedBase, rates);
		
		return service.parseRatesResponse(rates);
	}
	
	
	/**
	 * This endpoint is used to retrieve a list of conversion rate information between a specified currency code and multiple other currency codes.
	 *
	 * @param from The currency code of the currency to convert from
	 * @param to A list of currency codes of the currencies to convert to
	 * @param amount (optional) The amount of the currency to convert
	 * @return A list of ConversionRate objects containing the conversion rate information.
	 */
	@GetMapping("/rates/convert")
	public List<ConversionRate> getRatesFromAtoBlist(@RequestParam("from") String from,
			@RequestParam("to") List<String> to,
			@RequestParam(value = "amount", required = false) Optional<BigDecimal> amount) {
	
		RestTemplate restTemplate = new RestTemplate();
		BigDecimal amountVal = amount.orElse(BigDecimal.ONE);
		List<ConversionRate> conversions = new ArrayList<ConversionRate>();
		for (String toValue : to) {
			String url = String.format("https://api.exchangerate.host/convert?from=%s&to=%s&amount=%s", from, toValue,
					amountVal);
			conversions.add(restTemplate.getForObject(url, ConversionRate.class));
		}
		return service.parseConversionsResponse(conversions);
	}
}
