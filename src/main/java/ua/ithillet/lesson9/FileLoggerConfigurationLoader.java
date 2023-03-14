package ua.ithillet.lesson9;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileLoggerConfigurationLoader {

    public FileLoggerConfiguration load(String path) {
        Properties props = new Properties();
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            props.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String logPath = props.getProperty("path");
        LoggingLevel logLevel = LoggingLevel.valueOf(props.getProperty("level"));
        Long logMaxSize = Long.parseLong(props.getProperty("max.size"));

        return new FileLoggerConfiguration(logPath, logLevel, logMaxSize);
    }
}
