package dev.louiiuol.countries.domain.services.rest;

import dev.louiiuol.countries.domain.entities.Country;

public interface CountryRestApiService {

    public Country getByIso(String iso);

}