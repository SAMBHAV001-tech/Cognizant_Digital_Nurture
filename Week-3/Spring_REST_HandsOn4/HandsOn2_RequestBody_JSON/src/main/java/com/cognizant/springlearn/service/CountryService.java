package com.cognizant.springlearn.service;

import com.cognizant.springlearn.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {

    private final List<Country> countries;

    @SuppressWarnings("unchecked")
    public CountryService() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        this.countries = new ArrayList<>((List<Country>) context.getBean("countryList"));
    }

    public List<Country> getAllCountries() {
        return countries;
    }

    public Country getCountry(String code) {
        for (Country country : countries) {
            if (country.getCode().equalsIgnoreCase(code)) {
                return country;
            }
        }
        return null;
    }

    public void addCountry(Country country) {
        countries.add(country);
    }
}
