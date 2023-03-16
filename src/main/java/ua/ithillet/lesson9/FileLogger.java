package ua.ithillet.lesson9;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class FileLogger implements Logger {
    private FileLoggerConfiguration configuration;

    public FileLogger(FileLoggerConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public void debug(String message) {
        log(LoggingLevel.DEBUG, message);
    }

    @Override
    public void info(String message) {
        log(LoggingLevel.INFO, message);
    }

    private void log(LoggingLevel level, String message) throws FileMaxSizeReachedException {
        if (level.ordinal() > configuration.getLevel().ordinal()) {
            return;
        }

        String logMessage = String.format("[%s][%s] Message: %s%n",
                LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                level.name(), message);

        File logFile = new File(configuration.getPath());

        if (logFile.length() + logMessage.length() > configuration.getMaxSize()) {
            throw new FileMaxSizeReachedException(String.format("Maximum file size reached: %d bytes (current size: %d bytes) - %s",
                    configuration.getMaxSize(), logFile.length(), logFile.getAbsolutePath()));
        }

        try (FileWriter writer = new FileWriter(logFile, true)) {
            writer.write(logMessage);
        } catch (IOException e) {
            System.err.println("Error writing log message: " + e.getMessage());
        }
    }


}
