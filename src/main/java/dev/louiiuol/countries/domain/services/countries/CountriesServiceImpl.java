package dev.louiiuol.countries.domain.services.countries;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.louiiuol.countries.api.controllers.dtos.responses.CrountryViewDto;
import dev.louiiuol.countries.domain.entities.Country;
import dev.louiiuol.countries.domain.repositories.CountryJpaRepository;
import dev.louiiuol.countries.domain.services.rest.CountryRestApiServiceImpl;

@Service
public class CountriesServiceImpl implements CountriesService {

    @Autowired CountryRestApiServiceImpl countryRestApi;

    @Autowired ModelMapper mapper; 

    @Autowired CountryJpaRepository repo;

    @Override
    public CrountryViewDto getByIso(String iso) {

        Optional<Country> countryOpt = repo.findByCode(iso);
        Country entity;
        // Check if requested ISO is already in databse -> set view dto returned
        if(countryOpt.isPresent()) {
            entity = countryOpt.get();
        }
        // If not -> fetch it from external REST API -> Store in DB -> set view dto returned
        else {
            entity = repo.save(countryRestApi.getByIso(iso));
        }
        return mapper.map(entity, CrountryViewDto.class);
    }

}