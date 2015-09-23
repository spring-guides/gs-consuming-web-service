
package hello;

import hello.wsdl.GetCityForecastByZIPResponse;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	CommandLineRunner lookup(WeatherClient weatherClient) {
		return args -> {
			String zipCode = "94304";

			if (args.length > 0) {
				zipCode = args[0];
			}
			GetCityForecastByZIPResponse response = weatherClient.getCityForecastByZip(zipCode);
		};
	}

}
