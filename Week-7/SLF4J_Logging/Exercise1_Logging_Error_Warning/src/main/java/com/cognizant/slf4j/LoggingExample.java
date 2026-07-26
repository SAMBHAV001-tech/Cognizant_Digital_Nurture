package com.cognizant.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        logger.error("Database connection failed: Unable to connect to host localhost:5432");
        logger.warn("High memory usage warning: Memory utilization reached 88%");
    }
}
