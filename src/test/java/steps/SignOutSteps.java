package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SignUpPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SignOutSteps {

    HomePage homePage;
    LoginPage loginPage;

    public SignOutSteps(HomePage homePage, LoginPage loginPage) {
        this.homePage = homePage;
        this.loginPage = loginPage;
    }

    @Given("user is logIn")
    public void userIsLogIn() {
        assertTrue( homePage.haveLogo());
    }

    @When("user click on SignOut button")
    public void userClickOnSignOutButton() {
        homePage.hoverLogoIcon();
        homePage.logOut();
    }

    @Then("The user is disconnect")
    public void theUserIsDisconnect() {
        assertEquals(loginPage.loginTextDisplayed(),"Connexion");
    }

}
