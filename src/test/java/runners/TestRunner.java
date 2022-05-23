package runners;

import config.Properties;
import driverManager.WebDriverManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
        plugin = {
            "pretty",
            "html:target/reports/html/htmlreport",
            "json:target/reports/jsonreports/index.json",
            "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        features = {"src/test/resources/features"},
        glue = {"steps", "pageObjects"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

    private static WebDriver driver;

    @BeforeClass
    public static void beforeTest() {
        WebDriverManager.setDriver(Properties.SYSTEM_PROPERTIES.browser);
        driver = WebDriverManager.getDriver();
    }

    @AfterClass
    public static void afterTest() {
        WebDriverManager.getDriver().quit();
    }
    
}
