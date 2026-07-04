package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Transactional(readOnly = true)
    public Country findCountryByCode(String code) throws CountryNotFoundException {
        Optional<Country> result = countryRepository.findById(code);
        if (result.isPresent()) {
            return result.get();
        }
        throw new CountryNotFoundException("Country with code " + code + " not found");
    }

    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    @Transactional
    public void updateCountry(String code, String name) throws CountryNotFoundException {
        Optional<Country> result = countryRepository.findById(code);
        if (result.isPresent()) {
            Country country = result.get();
            country.setName(name);
            countryRepository.save(country);
        } else {
            throw new CountryNotFoundException("Country with code " + code + " not found");
        }
    }

    @Transactional
    public void deleteCountry(String code) throws CountryNotFoundException {
        if (countryRepository.existsById(code)) {
            countryRepository.deleteById(code);
        } else {
            throw new CountryNotFoundException("Country with code " + code + " not found");
        }
    }

    @Transactional(readOnly = true)
    public List<Country> findCountriesByNameContaining(String name) {
        return countryRepository.findByNameContaining(name);
    }
}
