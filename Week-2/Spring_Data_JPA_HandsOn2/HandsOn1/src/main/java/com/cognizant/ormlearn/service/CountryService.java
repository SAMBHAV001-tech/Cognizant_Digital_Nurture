package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Transactional(readOnly = true)
    public List<Country> searchCountriesContaining(String name) {
        return countryRepository.findByNameContainingOrderByNameAsc(name);
    }

    @Transactional(readOnly = true)
    public List<Country> searchCountriesStartingWith(String prefix) {
        return countryRepository.findByNameStartingWith(prefix);
    }
}
