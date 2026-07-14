package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/countries")
    public List<Country> getCountries() {
        LOGGER.info("START getCountries");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.info("END getCountries");
        return countries;
    }

    @GetMapping("/countries/{code}")
    public Country getCountryByCode(@PathVariable String code) {
        LOGGER.info("START getCountryByCode: {}", code);
        Country country = countryService.getCountry(code);
        if (country == null) {
            LOGGER.error("Country not found: {}", code);
            throw new CountryNotFoundException();
        }
        LOGGER.info("END getCountryByCode");
        return country;
    }

    @PostMapping("/countries")
    public Country addCountry(@Valid @RequestBody Country country) {
        LOGGER.info("START addCountry");
        LOGGER.debug("Received Country: {}", country);
        countryService.addCountry(country);
        LOGGER.info("END addCountry");
        return country;
    }
}
