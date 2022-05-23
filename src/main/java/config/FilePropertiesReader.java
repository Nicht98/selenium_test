package config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public enum FilePropertiesReader {

    INSTANCE;

    private static final String PROPERTIES_FILENAME = "config.properties";
    private static final String PROPERTIES_LOCATION = "config/" + PROPERTIES_FILENAME;

    private Properties properties;

    public final String firefoxDriverPath;
    public final String chromeDriverPath;
    public final String ieDriverPath;
    public final String operaPath;
    public final String msEdgePath;

    public static FilePropertiesReader getInstance() {
        return INSTANCE;
    }

    FilePropertiesReader() {
        try (BufferedReader reader = new BufferedReader(new FileReader(PROPERTIES_LOCATION))) {
            properties = new Properties();
            properties.load(reader);
            
        } catch (IOException e) {
            System.out.println(e);
        }
        firefoxDriverPath   = readProperty("firefoxDriverPath");
        chromeDriverPath    = readProperty("chromeDriverPath");
        ieDriverPath        = readProperty("ieDriverPath");
        operaPath           = readProperty("operaPath");
        msEdgePath          = readProperty("msEdgePath");
    }


    private String readProperty(String key) {
        String property = properties.getProperty(key);
        if (property == null) {
            System.out.println(key + " value is missing in config.properties");
        }
        return property;
    }

}
