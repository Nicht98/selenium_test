package pageObjects;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.Env;
import config.Properties;
import driverManager.WebDriverManager;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class Page {

    public static final Env ENV = Properties.SYSTEM_PROPERTIES.env;

    protected WebDriver driver;
    protected JavascriptExecutor js;
    protected Actions action;

    //Waiters declaration
    protected WebDriverWait wait;
    protected WebDriverWait shortWait;
    protected WebDriverWait middleWait;
    protected WebDriverWait longWait;

    //protected Configuration config = Properties.Config;

    Page(){
        // Init
        driver = WebDriverManager.getDriver();
        PageFactory.initElements(driver, this);

        js = (JavascriptExecutor) driver;
        action = new Actions(driver);

        //Waiters initialization
        wait        = new WebDriverWait(driver, Duration.ofSeconds(2));
        shortWait   = new WebDriverWait(driver, Duration.ofSeconds(10));
        middleWait  = new WebDriverWait(driver, Duration.ofSeconds(20));
        longWait    = new WebDriverWait(driver, Duration.ofSeconds(30));

    }

    /**
     * Wait until the condition in the function is satisfied
     *
     * @param isTrue the condition
     * @param <V>    the condition return type
     * @return true is thee condition is satisfied, false if the condition hasn't been satisfied in the given time
     */
    protected <V>boolean waitUntil(Function<? super WebDriver, V> isTrue){
        try{
            wait.until(isTrue);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void waitUntilDisplay(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(this.driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) webElement));
    }

    protected <V>boolean shortUntil(Function<? super WebDriver, V> isTrue){
        try{
            shortWait.until(isTrue);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    protected <V>boolean middleUntil(Function<? super WebDriver, V> isTrue){
        try{
            middleWait.until(isTrue);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    protected <V>boolean longUntil(Function<? super WebDriver, V> isTrue){
        try{
            longWait.until(isTrue);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * Wait until the page is loaded
     */
    protected void waitForLoadingPage(){
        if(!longUntil(driver->js.executeScript("return document.readyState").equals("complete") || js.executeScript("return document.readyState").equals("interactive") )){
            System.out.println(driver.getCurrentUrl() + " not loaded");
            return;
        }
        System.out.println(driver.getCurrentUrl() + " successfully loaded");
    }

    /**
     * Open the page with the given url
     * @param url
     */
    protected void get(String url){
        driver.get(url);
        waitForLoadingPage();
    }

    protected void clickOn(WebElement element){
        if( !shortUntil(visibilityOf(element)) ){
            System.out.println("Element not visible after click");
        }

        if( !shortUntil(elementToBeClickable(element))){
            System.out.println("Element not clickable");
        }
        element.click();
    }

    // @Attachment(value = "screenshot", type = "image/png")
    // public void saveScreenShotPNG(){
    //     Allure.addAttachment("screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    // }

    protected void scrollToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true); scrollBy(0, -window.innerHeight/2 + arguments[0].offsetHeight/2);", element);
    }

    protected void scrollUpToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true); scrollBy(0, -window.innerHeight/2 - arguments[0].offsetHeight/2);", element);
    }

    protected void scrollDownToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);arguments[0].scrollTop=arguments[0].scrollHeight", element);
    }


    public void sendKeysSlowly(WebElement webElement, String key) {
        for (int i = 0; i < key.length(); i++) {
            webElement.sendKeys(key.substring(i, i + 1));
        }
    }

    public void hoverClick( WebElement webElement){
        Actions action = new Actions(this.driver);
        action.moveToElement(webElement).perform();
    }

    // public void navigateTo(String link) {
    //     get(config.getEnvironment() + link);
    // }

}
