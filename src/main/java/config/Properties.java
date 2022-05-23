package config;

import driverManager.WebDriverManager;

public interface Properties {
    FilePropertiesReader   FILE_PROPERTIES   = FilePropertiesReader.getInstance();
    SystemPropertiesReader SYSTEM_PROPERTIES = SystemPropertiesReader.getInstance();
    WebDriverManager       WEBDRIVER_MANAGER = WebDriverManager.getInstance();
}
