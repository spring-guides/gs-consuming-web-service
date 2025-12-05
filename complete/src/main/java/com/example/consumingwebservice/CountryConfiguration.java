package com.example.consumingwebservice;

import org.springframework.boot.webservices.client.WebServiceTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CountryConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package configured in the build.gradle/pom.xml
		marshaller.setContextPath("com.example.consumingwebservice.wsdl");
		return marshaller;
	}

	@Bean
	public CountryClient countryClient(WebServiceTemplateBuilder builder, Jaxb2Marshaller marshaller) {
		builder = builder.setMarshaller(marshaller).setUnmarshaller(marshaller);

		CountryClient client = new CountryClient();
		client.setWebServiceTemplate(builder.build());
		client.setDefaultUri("http://localhost:8080/services");
		return client;
	}

}
