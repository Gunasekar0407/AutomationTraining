package Log4jExamples;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Log4jXmlConfiguratorExample {
    static Logger logger=Logger.getLogger(Log4jXmlConfiguratorExample.class);
    public static void main(String[] args) {
        DOMConfigurator.configure("C:\\Users\\gunasekar.dhanapal\\IdeaProjects\\Guna\\src\\main\\java\\Log4jExamples\\log4j.xml");
        //BasicConfigurator.configure();
        logger.debug("This is a debug message");
        logger.info("This is a info");
        logger.error("This is a error message");
        logger.fatal("This is a fatal message");
    }
}
