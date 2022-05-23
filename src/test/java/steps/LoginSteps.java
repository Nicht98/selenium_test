package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;

public class LoginSteps {
    
    private LoginPage loginPage;

    public LoginSteps(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    @Given("User is on the login page")
    public void userIsOnTheLoginPage() {
        loginPage.load();
    }

    @When("User enters his credentials {string} {string}")
    public void userEntersHisCredentials(String email, String password) {
        loginPage.fillLoginForm(email, password);
        loginPage.login();
    }

}
