package ua.ithillet.lesson9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FileLoggerConfigurationLoaderTest {
    
    @Test
    public void checkLoadLogs() {
        FileLoggerConfigurationLoader loader = new FileLoggerConfigurationLoader();
        FileLoggerConfiguration configFile = loader.load("src/main/resources/log_config.properties");

        Assertions.assertEquals("log", configFile.getPath());
        Assertions.assertEquals(LoggingLevel.DEBUG, configFile.getLevel());
        Assertions.assertEquals(200000, configFile.getMaxSize());
    }
}
