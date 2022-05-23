package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoToSignUpPage extends Page {
    @FindBy (linkText = "S'inscrire")
    WebElement btn_inscription;

    public void load() {
        get(ENV.getUrl("/auth/login"));
    }

    public void goToInscriptionPage(){
        clickOn(btn_inscription);
    }

    public boolean isInscriptionDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(this.btn_inscription));
        return this.btn_inscription.isDisplayed();
    }


}
