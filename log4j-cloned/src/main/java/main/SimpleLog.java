package main;

public class SimpleLog {
    private static org.apache.logging.log4j.Logger logger;

    public static void main(String[] args) {

        System.setProperty("log4j.configurationFile","../../resources/log4j2.xml");
        System.setProperty("log4j.configurationFile","C:\\Users\\Emanuel\\Documents\\Projects\\Hons\\dependencies-detection\\log4j-cloned\\src\\main\\resources\\log4j2.xml");
        logger = org.apache.logging.log4j.LogManager.getLogger(SimpleLog.class.getName());
                //org.apache.logging.log4j.LogManager.getLogger("main.SimpleLog");
        logger.info("Hello, World!");
    }
}
