package dev.louiiuol.countries.domain.services.rest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dev.louiiuol.countries.api.controllers.dtos.requests.CountryFromApiDto;
import dev.louiiuol.countries.domain.entities.Country;

@Service
public class CountryRestApiServiceImpl {

    @Value("${countries.external-apis.rest-countries.url}")
    private String root;

    private RestTemplate restTemplate;

    private ModelMapper mapper; 

    public CountryRestApiServiceImpl(RestTemplate restTemplate, ModelMapper mapper) {
        this.restTemplate = restTemplate;
        this.mapper = mapper;
    }

    public Country getByIso(String iso) {
        String uri = root + "alpha/" + iso;
        CountryFromApiDto dto = restTemplate.getForObject(uri, CountryFromApiDto.class);
        return mapper.map(dto, Country.class);
    }

}