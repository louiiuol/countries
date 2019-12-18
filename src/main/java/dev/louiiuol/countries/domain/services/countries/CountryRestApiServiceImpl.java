package dev.louiiuol.countries.domain.services.countries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dev.louiiuol.countries.domain.entities.Country;

@Service
class CountryRestApiServiceImpl {

    @Value("${countries.external-apis.rest-countries.url}")
    private String root;
    
    @Autowired RestTemplate restTemplate; 

    public Country getFromIso(String iso) {
        Country entity = new Country();
        String uri = root + "alpha/" + iso;
        entity = restTemplate.getForObject(uri, Country.class);
        entity.setCode(iso);
        return entity; 
    }
    
}