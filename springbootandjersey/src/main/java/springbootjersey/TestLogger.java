package springbootjersey;

import org.jboss.logging.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by tanghao on 2017/3/24.
 */
public class TestLogger {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestLogger.class);

    public static void main(String[] args) {
        logger.debug( "#########################3");
    }
}
