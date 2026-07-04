package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CountryService countryService) {
        return (args) -> {
            LOGGER.info("START - testSearchCountriesContaining");
            List<Country> list1 = countryService.searchCountriesContaining("ia");
            LOGGER.info("Countries containing 'ia': {}", list1);
            LOGGER.info("END - testSearchCountriesContaining");

            LOGGER.info("START - testSearchCountriesStartingWith");
            List<Country> list2 = countryService.searchCountriesStartingWith("U");
            LOGGER.info("Countries starting with 'U': {}", list2);
            LOGGER.info("END - testSearchCountriesStartingWith");
        };
    }
}
