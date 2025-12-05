
package com.example.consumingwebservice;

import java.util.List;

import com.example.consumingwebservice.wsdl.GetCountryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConsumingWebServiceApplication {

	Logger logger = LoggerFactory.getLogger(ConsumingWebServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ConsumingWebServiceApplication.class, args);
	}

	@Bean
	ApplicationRunner lookup(CountryClient countryClient) {
		return args -> {
			List<String> countryOption = args.getOptionValues("country");
			String country = (countryOption == null || countryOption.isEmpty()) ? "Spain" : countryOption.get(0);
			GetCountryResponse response = countryClient.getCountry(country);
			logger.info("Country [%s] has currency [%s].".formatted(country, response.getCountry().getCurrency()));
		};
	}

}
