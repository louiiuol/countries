package dev.louiiuol.countries.domain.services.countries.utils;

import dev.louiiuol.countries.api.controllers.dtos.responses.CrountryViewDto;
import dev.louiiuol.countries.domain.entities.Country;

public class CountriesServiceHelper {

    public static CrountryViewDto convert(Country entity) { 
        return new CrountryViewDto(entity.getCode(), entity.getNativeName(), entity.getRegion(), entity.getFlag());
    }
}