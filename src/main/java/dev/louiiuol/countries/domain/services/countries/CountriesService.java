package dev.louiiuol.countries.domain.services.countries;

import dev.louiiuol.countries.api.controllers.dtos.responses.CrountryViewDto;

public interface CountriesService {

    public CrountryViewDto getCountry(String countryIso);
}