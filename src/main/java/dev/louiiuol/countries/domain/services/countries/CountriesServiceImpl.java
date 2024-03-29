package dev.louiiuol.countries.domain.services.countries;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import dev.louiiuol.countries.api.controllers.dtos.responses.CountryViewDto;
import dev.louiiuol.countries.domain.entities.Country;
import dev.louiiuol.countries.domain.repositories.CountryJpaRepository;
import dev.louiiuol.countries.domain.services.rest.CountryRestApiServiceImpl;

@Service
public class CountriesServiceImpl implements CountriesService {

    private CountryRestApiServiceImpl countryRestApi;

    private ModelMapper mapper;

    private CountryJpaRepository repo;

    public CountriesServiceImpl(CountryRestApiServiceImpl countryRestApi, ModelMapper mapper,
            CountryJpaRepository repo) {
        this.countryRestApi = countryRestApi;
        this.mapper = mapper;
        this.repo = repo;
    }

    @Override
    public CountryViewDto getByIso(String iso) {

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
        return mapper.map(entity, CountryViewDto.class);
    }

}