package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringLearnApplication.class, args);
        displayDate();
        displayCountry();
        displayCountries();
    }

    public static void displayDate() {
        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
        SimpleDateFormat dateFormat = context.getBean("dateFormat", SimpleDateFormat.class);
        try {
            Date date = dateFormat.parse("31/12/2018");
            LOGGER.debug("Date: {}", date);
        } catch (ParseException e) {
            LOGGER.error("Date parsing error", e);
        }
        LOGGER.info("END");
    }

    public static void displayCountry() {
        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("country", Country.class);
        LOGGER.debug("Country: {}", country.toString());
        LOGGER.info("END");
    }

    @SuppressWarnings("unchecked")
    public static void displayCountries() {
        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        List<Country> countries = (List<Country>) context.getBean("countryList");
        for (Country country : countries) {
            LOGGER.debug("Country: {}", country.toString());
        }
        LOGGER.info("END");
    }
}
