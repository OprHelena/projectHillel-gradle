package ua.ithillet.lesson23;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesController {

    public static final String WORKING_DIR_PATH = System.getProperty("user.dir");
    private static final String CURRENT_ENV_PROPERTY = System.getProperty("env.property.properties");

    public static String getEnvPropertyValue(final String propertyKey) {
        String propertyValue = null;
        FileInputStream fileInputStream;
        Properties properties = new Properties();

        try {
            fileInputStream = new FileInputStream(WORKING_DIR_PATH + CURRENT_ENV_PROPERTY);
            properties.load(fileInputStream);

            propertyValue = properties.getProperty(propertyKey);

        }catch (IOException e) {
           e.getStackTrace();
        }

        return propertyValue;
    }

}
