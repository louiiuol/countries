package dev.louiiuol.countries;

import javax.validation.Validator;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.MatchingStrategies;
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

	/** <p> Default {@code ModelMapper} bean that configures mapping between DTO and entities. </p>
	 * <i> field matching is enabled with private access and standard matching strategy. </i>
	 * @return an instance of {@code ModelMapper} */
	@Bean
	protected ModelMapper modelMapper() {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(AccessLevel.PRIVATE)
														.setMatchingStrategy(MatchingStrategies.STANDARD);
		return mapper;
	}
	
}
