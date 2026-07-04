package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CountryService countryService) {
        return (args) -> {
            try {
                LOGGER.info("START - findCountryByCode('IN')");
                Country country = countryService.findCountryByCode("IN");
                LOGGER.info("Retrieved Country: {}", country);
                LOGGER.info("END - findCountryByCode('IN')");
            } catch (Exception e) {
                LOGGER.error("Error finding country: ", e);
            }
        };
    }
}
