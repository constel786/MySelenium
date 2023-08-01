package com.myfirstproject.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class LoggerUtils {
    /*
    The purpose of this class is to reuse logger in the entire project
    We can call these methods in the test classes: LoggerUtils.info("my message")
     */
    private static Logger logger = (Logger) LogManager.getLogger(LoggerUtils.class.getName());
    public static void debug(String message){
        logger.debug(message);
    }
    public static void fatal(String message) {
        logger.fatal(message);
    }
    public static void error(String message) {
        logger.error(message);
    }
    public static void warn(String message) {
        logger.warn(message);
    }
    public static void info(String message) {
        logger.info(message);
    }
}
