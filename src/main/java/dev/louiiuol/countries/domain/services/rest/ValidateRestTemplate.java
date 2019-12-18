package dev.louiiuol.countries.domain.services.rest;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class ValidateRestTemplate extends RestTemplate {

    private final Validator validator;

    public ValidateRestTemplate(Validator validator) {
        this.validator = validator;
    }

    @Override
    public <T> T getForObject(String url, Class<T> responseType, Object... uriVariables) throws RestClientException {
        T dto =  super.getForObject(url, responseType, uriVariables);
        final Set<ConstraintViolation<Object>> violations = validator.validate(dto);
        if (violations.isEmpty()) {
            return dto;
        }
        throw new ConstraintViolationException("dto's fields need to be updated", violations);
    }

}