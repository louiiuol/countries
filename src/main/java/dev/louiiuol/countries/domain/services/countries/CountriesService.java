package dev.louiiuol.countries.domain.services.countries;

import dev.louiiuol.countries.api.controllers.dtos.responses.CountryViewDto;

public interface CountriesService {

    public CountryViewDto getByIso(String countryIso);
    
}