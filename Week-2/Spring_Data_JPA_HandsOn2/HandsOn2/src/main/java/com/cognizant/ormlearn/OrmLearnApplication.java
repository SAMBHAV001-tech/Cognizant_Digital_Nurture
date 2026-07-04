package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.service.StockService;
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
    public CommandLineRunner demo(StockService stockService) {
        return (args) -> {
            LOGGER.info("START - FB September 2019");
            List<Stock> fbList = stockService.getFbStocksSept2019();
            LOGGER.info("FB Stocks: {}", fbList);
            LOGGER.info("END - FB September 2019");

            LOGGER.info("START - Google > 1250");
            List<Stock> googList = stockService.getGoogleStocksAbove1250();
            LOGGER.info("Google Stocks: {}", googList);
            LOGGER.info("END - Google > 1250");

            LOGGER.info("START - Top 3 Highest Volume");
            List<Stock> topVolumeList = stockService.getTop3HighestVolumeStocks();
            LOGGER.info("Top Volume Stocks: {}", topVolumeList);
            LOGGER.info("END - Top 3 Highest Volume");

            LOGGER.info("START - Lowest 3 Netflix");
            List<Stock> lowestNflxList = stockService.getLowest3NflxStocks();
            LOGGER.info("Lowest Netflix Stocks: {}", lowestNflxList);
            LOGGER.info("END - Lowest 3 Netflix");
        };
    }
}
