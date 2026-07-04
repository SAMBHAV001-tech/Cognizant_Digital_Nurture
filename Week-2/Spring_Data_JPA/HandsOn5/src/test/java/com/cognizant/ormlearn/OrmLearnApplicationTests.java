package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrmLearnApplicationTests {

    @Autowired
    private CountryService countryService;

    @Test
    void testFindCountryByCodeSuccess() throws CountryNotFoundException {
        Country country = countryService.findCountryByCode("IN");
        assertNotNull(country);
        assertEquals("India", country.getName());
    }

    @Test
    void testFindCountryByCodeNotFound() {
        assertThrows(CountryNotFoundException.class, () -> {
            countryService.findCountryByCode("XX");
        });
    }

    @Test
    void testAddCountry() throws CountryNotFoundException {
        Country country = new Country("BR", "Brazil");
        countryService.addCountry(country);

        Country retrieved = countryService.findCountryByCode("BR");
        assertNotNull(retrieved);
        assertEquals("Brazil", retrieved.getName());
    }

    @Test
    void testUpdateCountry() throws CountryNotFoundException {
        countryService.updateCountry("US", "United States of America");
        Country retrieved = countryService.findCountryByCode("US");
        assertEquals("United States of America", retrieved.getName());
    }

    @Test
    void testDeleteCountry() {
        assertDoesNotThrow(() -> {
            countryService.deleteCountry("DE");
        });
        assertThrows(CountryNotFoundException.class, () -> {
            countryService.findCountryByCode("DE");
        });
    }

    @Test
    void testFindCountriesByNameContaining() {
        List<Country> countries = countryService.findCountriesByNameContaining("In");
        assertFalse(countries.isEmpty());
        assertTrue(countries.stream().anyMatch(c -> c.getName().contains("India")));
    }
}
