package dev.louiiuol.countries.api.controllers;

import org.springframework.web.bind.annotation.RestController;

import dev.louiiuol.countries.api.controllers.dtos.responses.CountryViewDto;
import dev.louiiuol.countries.domain.services.countries.CountriesService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/countries")
public class CountriesController {

    private CountriesService service;

    protected CountriesController(CountriesService service) {
        this.service = service;
    }

    @GetMapping(value = "/{iso}")
    public CountryViewDto getByIso(@PathVariable String iso) { return service.getByIso(iso.toUpperCase()); }

}