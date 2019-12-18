package dev.louiiuol.countries.domain.services.countries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.louiiuol.countries.api.controllers.dtos.responses.CrountryViewDto;
import dev.louiiuol.countries.domain.entities.Country;
import dev.louiiuol.countries.domain.repositories.CountryJpaRepository;
import dev.louiiuol.countries.domain.services.countries.utils.CountriesServiceHelper;
import dev.louiiuol.countries.domain.services.rest.CountryRestApiServiceImpl;

@Service
public class CountriesServiceImpl implements CountriesService {

    @Autowired CountryRestApiServiceImpl countryRestApi;

    @Autowired CountryJpaRepository repo;

    @Override
    public CrountryViewDto getByIso(String iso) {

        CrountryViewDto view;
        // Check if requested ISO is already in databse -> set view dto returned
        if(repo.existsByCode(iso)) {
            Country entity = repo.findByCode(iso); 
            view = CountriesServiceHelper.convert(entity);
        }
        // If not -> fetch it from external REST API -> Store in DB -> set view dto returned
        else {
            Country entity = countryRestApi.getFromIso(iso);
            view = CountriesServiceHelper.convert(repo.save(entity));
        }
        return view; 
    }

}