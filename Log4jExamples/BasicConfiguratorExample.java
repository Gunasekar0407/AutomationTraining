package Log4jExamples;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class BasicConfiguratorExample {
    static Logger logger=Logger.getLogger(BasicConfiguratorExample.class);// factorydesign pattern
    public static void main(String[] args) {
        BasicConfigurator.configure(); // basicconfigurator is a default class.
    logger.debug("This is a debug message");
    logger.info("This is a info");
    logger.error("This is a error message");
    logger.fatal("This is a fatal message");
    }
}
