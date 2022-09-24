package main;

import cloned.org.apache.logging.log4j.LogManager;
import cloned.org.apache.logging.log4j.Logger;

public class SimpleLog {
    private static Logger logger;

    public static void main(String[] args) {

        System.setProperty("log4j.configurationFile","../../resources/log4j2.xml");
        System.setProperty("log4j.configurationFile","C:\\Users\\Emanuel\\Documents\\Projects\\Hons\\dependencies-detection\\log4j-cloned\\src\\main\\resources\\log4j2.xml");
        logger = LogManager.getLogger(SimpleLog.class.getName());
                //org.apache.logging.log4j.LogManager.getLogger("main.SimpleLog");
        logger.info("Hello, World!");
    }
}
