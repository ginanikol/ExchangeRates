package gina.nikol.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Exchange Rates Demo API", description = "A demo API with Spring boot that fetches exchange-rates from the publicly available API, https://exchangerate.host.\n"))
public class ExchangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExchangeApplication.class, args);
	}

}
