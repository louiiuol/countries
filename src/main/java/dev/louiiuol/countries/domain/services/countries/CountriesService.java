package dev.louiiuol.countries.domain.services.countries;

import dev.louiiuol.countries.api.controllers.dtos.responses.CrountryViewOtd;

public interface CountriesService {

    public CrountryViewOtd getCountry(String countryIso);
}