package dev.louiiuol.countries.domain.services.countries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dev.louiiuol.countries.api.controllers.dtos.responses.CrountryViewOtd;
import dev.louiiuol.countries.domain.entities.Country;
import dev.louiiuol.countries.domain.repositories.CountryJpaRepository;

@Service
public class CountriesServiceImpl implements CountriesService {

    final String root = "https://restcountries.eu/rest/v2/";

    @Autowired CountryJpaRepository repo;

    @Override
    public CrountryViewOtd getCountry(String codeIso) {

        CrountryViewOtd view; 
        // Check if requested ISO is already in databse -> set view object returned
        if(repo.existsByCode(codeIso)) {
            Country entity = repo.findByCode(codeIso); 
            view = CountriesServiceHelper.convert(entity);
        }
        // If not -> fetch it from external REST API -> Store in DB -> set view object returned
        else {
            String uri = root + "alpha/" + codeIso;
            Country entity = new RestTemplate().getForObject(uri, Country.class);
            entity.setCode(codeIso);
            view = CountriesServiceHelper.convert(repo.save(entity));
        }
        return view; 
    }
}