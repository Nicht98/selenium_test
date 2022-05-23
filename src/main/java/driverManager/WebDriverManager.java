package driverManager;

import org.openqa.selenium.WebDriver;

import drivers.Driver;
import drivers.DriverFactory;

public final class WebDriverManager {

    private static final WebDriverManager INSTANCE = new WebDriverManager();

    private static ThreadLocal<Driver> driver = new ThreadLocal<>();

    private WebDriverManager() {
    }

    public static WebDriverManager getInstance() {
        return INSTANCE;
    }

    public static WebDriver getDriver() {
        return driver.get().getDriver();
    }

    public static void setDriver(String browser) {
        driver.set(DriverFactory.getDriver(browser));
    }
    
}
