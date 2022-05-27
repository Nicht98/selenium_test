package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class HomePage extends Page {
    
    @FindBy(css = "nav h1")
    private WebElement logo;

    @FindBy (css = "div:nth-child(1) div:nth-child(1) nav:nth-child(4) div:nth-child(5) > a:nth-child(2)")
    WebElement logOut_btn;

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

    @FindBy (linkText = "Mes favoris")
    WebElement whishlist_btn;


    @FindBy (css = "style_card_wrapper__hrc1I")
    private List <WebElement> cartItem;

    @FindBy (className = "style_trash_product_cart__7Yzni")
    private WebElement delete_btn;

   /*
    @FindBy(css = "#style_content_cart_wrapper__mqNbf > svg")
    private WebElement cartlogoBtn;*/

    @FindBy  (id = "style_content_cart_wrapper__mqNbf")
    private WebElement cartlogoBtn;

    @FindBy (id = "style_btn_close__9uLzQ")
    private WebElement closeDetailbtn;

    @FindBy (css = "div:nth-child(1) div.style_container_cart__WEZ1i:nth-child(1) div:nth-child(2) div:nth-child(1) > p:nth-child(2)")
    private WebElement emptyMessage;

     @FindBy (className = "style_quantity_in__XmF4D")
     private WebElement add_btn;

    public boolean userLogoDisplayed(){
        return shortUntil(visibilityOf(userLogo));
    }

    public boolean haveLogo() {
        return shortUntil(visibilityOf(logo));
    }

    public void hoverLogoIcon(){
        shortUntil(ExpectedConditions.visibilityOfAllElements());
        hoverClick(userLogo);
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
        shortUntil(ExpectedConditions.visibilityOfAllElements());
        //this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        clickOn(addTocartBtn);
    }

    public void selectProduct(){
        //longUntil(ExpectedConditions.urlContains("home"));
        waitForLoadingPage();
        shortUntil(ExpectedConditions.visibilityOfAllElements());
        //longUntil(visibilityOf(productImage));
        clickOn(productImage);
    }

    public void goToCart(){
        shortUntil(ExpectedConditions.visibilityOfAllElements());
        clickOn(cartlogoBtn);
        waitForLoadingPage();
    }

    public void openCart() {
        clickOn(cartlogoBtn);
        waitForLoadingPage();
    }

    public boolean isCartPageEmpty(){
        shortUntil(visibilityOf(cartPage));
        System.out.println("le logo est : " +!cartPage.isDisplayed());
        return !cartPage.isDisplayed();
    }

    public void logOut(){
        shortUntil(ExpectedConditions.visibilityOfAllElements());
        logOut_btn.click();
    }

    public void goToWhislist(){
        shortUntil(ExpectedConditions.visibilityOfAllElements());
        clickOn(whishlist_btn);
    }

    public void deleteItem(){
        shortUntil(ExpectedConditions.visibilityOfAllElements());
       delete_btn.click();

    }

    public int getCartsize(){
            return cartItem.size();
    }

    public void decrease_item_number(){

    }

    public void increaseQuant(){
        add_btn.click();
    }

    public boolean isEmptyMessage(){
        shortUntil(ExpectedConditions.visibilityOfAllElements());
        return emptyMessage.isDisplayed();
    }

    /*public void closeDetailProductPage(){
        clickOn(closeDetailbtn);
    }*/

    public void waitUntilOption(){
        shortUntil(ExpectedConditions.visibilityOfAllElements());
    }

}
