package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class SignUpPage extends Page {
    @FindBy (id = "email_register")
    WebElement emailField;
    @FindBy (id="password_register")
    WebElement passField;
    @FindBy (id ="confirm_password_register")
    WebElement confPassField;
    @FindBy (id = "btn_register")
    WebElement btn_register;
    @FindBy (css = "div h1")
    WebElement SignUpLogos;

    public void load() {
        get(ENV.getUrl("/auth/register"));
    }

    public void fillsigningUpForm (String email, String pass, String confPass){
        sendKeysSlowly(emailField,email);
        sendKeysSlowly(passField,pass);
        sendKeysSlowly(confPassField,confPass);
    }

    public void SignUp(){
        clickOn(btn_register);
    }


    public boolean haveLogo() {
        return shortUntil(visibilityOf(SignUpLogos));
    }
}
