import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SimpleLog {
    private static final Logger logger = LogManager.getLogger("SimpleLog");

    public static void main(String[] args) {
        logger.info("Hello, World!");
    }
}
