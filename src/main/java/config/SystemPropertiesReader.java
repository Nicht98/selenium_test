package config;

public enum SystemPropertiesReader {
   
    INSTANCE;

    public final Env env;
    public final boolean headless;

    public final String browser;
    public final String version;

    SystemPropertiesReader() {
        env = Env.parse(System.getProperty("env", "production").toUpperCase());
        headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
        browser = System.getProperty("browser", "chrome");
        version = System.getProperty("version", "unspecified");
    }

    public static SystemPropertiesReader getInstance() {
        return INSTANCE;
    }
    
}
