package dev.louiiuol.countries;

import javax.validation.Validator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import dev.louiiuol.countries.domain.services.rest.ValidateRestTemplate;

@SpringBootApplication
public class CountriesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountriesApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate(Validator validator) {
		return new ValidateRestTemplate(validator);
	}
	
}
