package ua.ithillet.lesson9;

public class Main {
    public static void main(String[] args) {
        FileLoggerConfiguration configuration = new FileLoggerConfiguration("log.txt", LoggingLevel.DEBUG, 1024);
        FileLoggerConfiguration configurationInfo = new FileLoggerConfiguration("log.txt", LoggingLevel.INFO, 1024);
        FileLoggerConfigurationLoader loader = new FileLoggerConfigurationLoader();
        FileLoggerConfiguration fileConfig = loader.load("src/main/resources/log_config.properties");

        FileLogger logger = new FileLogger(configuration);
        FileLogger loggerInfo = new FileLogger(configurationInfo);
        try {
            logger.debug("Debug message");
            logger.info("Info message");
            loggerInfo.debug("Debug message");
            loggerInfo.info("Info message");
        } catch (FileMaxSizeReachedException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("Path: " + fileConfig.getPath());
    }
}
