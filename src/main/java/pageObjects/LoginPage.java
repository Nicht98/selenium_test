package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {
    
    @FindBy(id = "email_login")
    private WebElement emailField;

    @FindBy(id = "password_login")
    private WebElement passwordField;

    @FindBy(id = "btn_login")
    private WebElement connectionButton;

    @FindBy( xpath = "//h1[contains(text(),'Connexion')]")
    private WebElement logInLogos;

    public void load() {
        get(ENV.getUrl("/auth/login"));
    }

    public void fillLoginForm(String email, String password) {
        sendKeysSlowly(emailField, email);
        sendKeysSlowly(passwordField, password);
    }

    public String loginTextDisplayed(){
        System.out.println("The logInpage text is : "+logInLogos.getText());
        return logInLogos.getText();
    }

    public void login() {
        clickOn(connectionButton);
    }

}
