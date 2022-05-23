package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import config.Properties;

public class LocalDriver implements Driver {

    private static final String CHROME_DRIVER_PROPERTY  = "webdriver.chrome.driver";
    private static final String GECKO_DRIVER_PROPERTY   = "webdriver.gecko.driver";

    private final WebDriver driver;

    public LocalDriver(String browser) {
        this.driverSetUp(browser);
        switch (browser.toLowerCase()) {
            case "firefox":
                this.driver = new FirefoxDriver(getFirefoxOptions());
                break;
        
            default:
                this.driver = new ChromeDriver(getChromeOptions());
                break;
        }
    }
    
    @Override
    public WebDriver getDriver() {
        return this.driver;
    }

    @Override
    public void closeDriver() {
        this.driver.close();
    }

    private void driverSetUp(String browser) {
        String prop, path;
        switch (browser.toLowerCase()) {
            case "firefox":
                prop = GECKO_DRIVER_PROPERTY;
                path = Properties.FILE_PROPERTIES.firefoxDriverPath;
                break;
        
            default:
                prop = CHROME_DRIVER_PROPERTY;
                path = Properties.FILE_PROPERTIES.chromeDriverPath;
                break;
        }
        System.setProperty(prop, path);
    }

}
