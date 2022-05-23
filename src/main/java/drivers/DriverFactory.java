package drivers;

public class DriverFactory {

    public static Driver getDriver(String browser) {
        return new LocalDriver(browser);
    }
    
}
