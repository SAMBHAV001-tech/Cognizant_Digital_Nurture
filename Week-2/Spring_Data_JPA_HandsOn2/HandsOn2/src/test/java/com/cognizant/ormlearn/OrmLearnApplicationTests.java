package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.service.StockService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrmLearnApplicationTests {

    @Autowired
    private StockService stockService;

    @Test
    void testGetFbStocksSept2019() {
        List<Stock> list = stockService.getFbStocksSept2019();
        assertEquals(2, list.size());
        assertTrue(list.stream().allMatch(s -> s.getCode().equals("FB")));
    }

    @Test
    void testGetGoogleStocksAbove1250() {
        List<Stock> list = stockService.getGoogleStocksAbove1250();
        assertEquals(2, list.size());
        assertTrue(list.stream().allMatch(s -> s.getCode().equals("GOOG") && s.getClose() > 1250.0));
    }

    @Test
    void testGetTop3HighestVolumeStocks() {
        List<Stock> list = stockService.getTop3HighestVolumeStocks();
        assertEquals(3, list.size());
        assertEquals(15000000L, list.get(0).getVolume());
        assertEquals(14000000L, list.get(1).getVolume());
        assertEquals(12000000L, list.get(2).getVolume());
    }

    @Test
    void testGetLowest3NflxStocks() {
        List<Stock> list = stockService.getLowest3NflxStocks();
        assertEquals(3, list.size());
        assertEquals(278.0, list.get(0).getClose());
        assertEquals(282.0, list.get(1).getClose());
        assertEquals(285.0, list.get(2).getClose());
    }
}
