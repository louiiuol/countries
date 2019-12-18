package dev.louiiuol.countries.api.controllers;

import org.springframework.web.bind.annotation.RestController;

import dev.louiiuol.countries.api.controllers.dtos.responses.CrountryViewDto;
import dev.louiiuol.countries.domain.services.countries.CountriesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/countries")
public class CountriesController {

    @Autowired CountriesService service;

    @GetMapping(value = "/{iso}")
    public CrountryViewDto getByIso(@PathVariable String iso) { return service.getByIso(iso); }
    
}