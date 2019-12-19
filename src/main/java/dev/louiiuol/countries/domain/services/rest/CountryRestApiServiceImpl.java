package dev.louiiuol.countries.domain.services.rest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dev.louiiuol.countries.api.controllers.dtos.requests.CountryFromApiDto;
import dev.louiiuol.countries.domain.entities.Country;

@Service
public class CountryRestApiServiceImpl {

    @Value("${countries.external-apis.rest-countries.url}")
    private String root;
    
    @Autowired RestTemplate restTemplate;

    @Autowired ModelMapper mapper; 

    public Country getByIso(String iso) {
        String uri = root + "alpha/" + iso;
        CountryFromApiDto dto = restTemplate.getForObject(uri, CountryFromApiDto.class);
        return mapper.map(dto, Country.class);
    }
    
}