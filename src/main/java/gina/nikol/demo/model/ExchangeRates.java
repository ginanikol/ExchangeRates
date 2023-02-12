package gina.nikol.demo.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

public class ExchangeRates {

	Map<String, BigDecimal> rates;
	private String base;
	private Date date;

	public Map<String, BigDecimal> getRates() {
		return rates;
	}

	public void setRates(Map<String, BigDecimal> rates) {
		this.rates = rates;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ExchangeRates [rates=" + rates + ", base=" + base + ", date=" + date + "]";
	}

}
