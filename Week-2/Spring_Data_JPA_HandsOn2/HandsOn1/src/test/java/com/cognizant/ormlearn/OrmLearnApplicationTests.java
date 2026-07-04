package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
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
    void testSearchCountriesContaining() {
        List<Country> list = countryService.searchCountriesContaining("ia");
        assertFalse(list.isEmpty());
        assertEquals("India", list.get(0).getName());
    }

    @Test
    void testSearchCountriesStartingWith() {
        List<Country> list = countryService.searchCountriesStartingWith("U");
        assertFalse(list.isEmpty());
        assertEquals("United States", list.get(0).getName());
    }
}
