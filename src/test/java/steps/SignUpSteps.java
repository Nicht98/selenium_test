
package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.SignUpPage;
import static org.testng.Assert.assertTrue;

public class SignUpSteps {
    SignUpPage signUpPage;
    HomePage homePage;

    public SignUpSteps(SignUpPage signUpPage, HomePage homePage) {
        this.signUpPage = signUpPage;
        this.homePage = homePage;
    }

    public SignUpSteps(SignUpPage signUpPage) {
        this.signUpPage = signUpPage;
    }

    @Given("I am on the registration page")
    public void iAmOnTheRegistrationPage() {
        signUpPage.load();
    }

    @When("I fill in email field with {string} {string} {string}")
    public void iFillInEmailFieldWith(String email, String password, String confPass) {
        signUpPage.fillsigningUpForm(email, password, confPass);
    }

    @And("I click on the button Inscription")
    public void iClickOnTheButtonInscription() {
        signUpPage.SignUp();
    }

    @Then("The homepage is displayed")
    public void theHomepageIsDisplayed() {
        assertTrue(homePage.userLogoDisplayed(),"the green user logos is not available");
    }


}