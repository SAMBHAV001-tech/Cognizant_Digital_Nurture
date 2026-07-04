package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class StockService {

    private final StockRepository stockRepository;

    @Autowired
    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Transactional(readOnly = true)
    public List<Stock> getFbStocksSept2019() {
        return stockRepository.findByCodeAndDateBetween("FB", LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30));
    }

    @Transactional(readOnly = true)
    public List<Stock> getGoogleStocksAbove1250() {
        return stockRepository.findByCodeAndCloseGreaterThan("GOOG", 1250.0);
    }

    @Transactional(readOnly = true)
    public List<Stock> getTop3HighestVolumeStocks() {
        return stockRepository.findTop3ByOrderByVolumeDesc();
    }

    @Transactional(readOnly = true)
    public List<Stock> getLowest3NflxStocks() {
        return stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");
    }
}
