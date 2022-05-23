package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import pageObjects.GoToSignUpPage;
import pageObjects.SignUpPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class goToSignUpSteps {
    public LoginPage loginPage;
    private GoToSignUpPage goToSignUpPage;
    private SignUpPage signUpPage;

    public goToSignUpSteps(LoginPage loginPage, GoToSignUpPage goToSignUpPage, SignUpPage signUpPage) {
        this.loginPage = loginPage;
        this.goToSignUpPage = goToSignUpPage;
        this.signUpPage = signUpPage;
    }

    @Given("User is on the login")
    public void userIsOnTheLoginPage() {
        loginPage.load();
    }

    @When("User click on signUp button")
    public void clickOnSignUpButton() {
        goToSignUpPage.goToInscriptionPage();
}

    @Then("signUp page is open")
    public void userIsRedirectionToSignUpPage(){
        assertTrue(signUpPage.haveLogo(),"SignUp page doesnt have logos");
    }

}
