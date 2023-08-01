package com.myfirstproject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.Test;

public class Day12_Log4J2 {
    private static Logger logger = (Logger) LogManager.getLogger(Day12_Log4J2.class.getName());
    @Test
    public void log4J2Test(){
        System.out.println("Fatal log..."); //Less detailed print
        /*
        By default, the level is ERROR and FATAL
        To be able to see other error logs, use .xml setting/configuration file
         */
        logger.fatal("Fatal log..."); //More detailed print
        logger.error("Error log...");
        logger.warn("Warning log...");
        logger.debug("Debug log...");
        logger.info("Info log...");



    }

}
