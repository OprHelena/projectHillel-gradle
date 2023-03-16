package ua.ithillet.lesson9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FileLoggerConfigurationLoaderTest {

    @BeforeEach
    public void inputLogToFile() {
        FileLoggerConfiguration configuration = new FileLoggerConfiguration("log.txt", LoggingLevel.DEBUG, 1024);
        FileLogger logger = new FileLogger(configuration);
        try {
            logger.debug("Debug message");
            logger.info("Info message");
        } catch (FileMaxSizeReachedException e) {
            System.err.println(e.getMessage());
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void checkLoadLogs() {
        FileLoggerConfigurationLoader loader = new FileLoggerConfigurationLoader();
        FileLoggerConfiguration configFile = loader.load("src/main/resources/log_config.properties");

        Assertions.assertEquals("log", configFile.getPath());
        Assertions.assertEquals(LoggingLevel.DEBUG, configFile.getLevel());
        Assertions.assertEquals(200000, configFile.getMaxSize());
    }

    @Test
    public void checkTextFromFile() {
        WorkWithLogFile workWithLogFile = new WorkWithLogFile("log.txt");
        Assertions.assertTrue(workWithLogFile.readTextFromFile(workWithLogFile.getPath(), "[DEBUG] Message: Debug message", workWithLogFile.getCurrentDate()).contains("23"));
    }

}
