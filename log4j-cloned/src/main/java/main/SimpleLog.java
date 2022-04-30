package main;

public class SimpleLog {
    private static final org.apache.logging.my_log4j.Logger logger = org.apache.logging.my_log4j.LogManager.getLogger("main.SimpleLog");

    public static void main(String[] args) {
        logger.info("Hello, World!");
    }
}
