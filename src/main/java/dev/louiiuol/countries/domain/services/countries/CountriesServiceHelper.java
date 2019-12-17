package dev.louiiuol.countries.domain.services.countries;

import dev.louiiuol.countries.api.controllers.dtos.responses.CrountryViewOtd;
import dev.louiiuol.countries.domain.entities.Country;

class CountriesServiceHelper {

    static CrountryViewOtd convert(Country entity) {
	    return new CrountryViewOtd(entity.getCode(), entity.getNativeName(), entity.getRegion(), entity.getFlag());
    }
}