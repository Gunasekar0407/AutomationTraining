package Log4jExamples;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class PropertyLog4jExample {
    String userDirectory = System.getProperty("user.dir");
    String pathSeparator = System.getProperty("file.separator");
    static Logger logger=Logger.getLogger(PropertyLog4jExample.class);
    public static void main(String[] args) {
        PropertyConfigurator.configure("C:\\Users\\gunasekar.dhanapal\\IdeaProjects\\Guna\\src\\main\\java\\Log4jExamples\\log4j.Properties");
        //BasicConfigurator.configure();
        logger.debug("This is a debug message");
        logger.info("This is a info");
        logger.error("This is a error message");
        logger.fatal("This is a fatal message");
    }
}
