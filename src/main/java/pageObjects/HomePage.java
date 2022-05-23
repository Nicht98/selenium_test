package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class HomePage extends Page {
    
    @FindBy(css = "nav h1")
    private WebElement logo;

    @FindBy (xpath = "//body/div[@id='__next']/div[1]/nav[1]/div[4]/*[1]")
    WebElement userLogo ;

    @FindBy (id = "style_input_navbar_search__Scaxy")
    WebElement searchKeyword;

    @FindBy (id = "style_empty_result___y6P_")
    WebElement searchEmptyResult;

    @FindBy (xpath = "//button[@id='style_btn_add_cart__gTXM7']")
    WebElement addTocartBtn;

    @FindBy (xpath = "//p[contains(text(),'Votre panier est vide')]")
    WebElement cartPage;

    @FindBy(xpath = "//body/div[@id='__next']/div[1]/main[1]/div[1]/div[1]/div[1]/span[1]/img[1]")
    WebElement productImage;

    @FindBy  (id = "style_content_cart_wrapper__mqNbf")
    WebElement cartlogoBtn;

    @FindBy (id = "style_btn_close__9uLzQ")
    WebElement closeDetailbtn;

    public boolean userLogoDisplayed(){
        return shortUntil(visibilityOf(userLogo));
    }

    public boolean haveLogo() {
        return shortUntil(visibilityOf(logo));
    }

    public void load (){
        get(ENV.getUrl("/home"));
    }

    public void fillsearchBar(String keyword){
        wait.until(ExpectedConditions.visibilityOf(this.searchKeyword));
        sendKeysSlowly(searchKeyword,keyword);
    }

    public boolean Isempty (){
        wait.until(ExpectedConditions.visibilityOf(this.searchEmptyResult));
        return searchEmptyResult.isDisplayed();
    }

    public void addToCart(){
        waitUntil(visibilityOf(addTocartBtn));
        //this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        clickOn(addTocartBtn);
    }

    public void selectProduct(){
        longUntil(visibilityOf(productImage));
        clickOn(productImage);
    }

    public void goToCart(){
        clickOn(cartlogoBtn);
    }

    public boolean isCartPageEmpty(){
        longUntil(visibilityOf(cartPage));
        return !cartPage.isDisplayed();
    }

    /*public void closeDetailProductPage(){
        clickOn(closeDetailbtn);
    }*/

}
