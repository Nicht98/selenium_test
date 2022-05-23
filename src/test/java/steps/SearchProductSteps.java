package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class SearchProductSteps {

    HomePage homePage;

    public SearchProductSteps(HomePage homePage) {
        this.homePage = homePage;
    }

    @Given("User is on HomePage")
    public void userIsOnHomePage() {
        assertTrue(homePage.haveLogo());
    }

    @When("User enter a {string} in search bar")
    public void userEnterAInSearchBar(String keyword) {
            homePage.fillsearchBar(keyword);
    }

    @Then("User should see a page display with choosen product results")
    public void userShouldSeeAPageDisplayWithChoosenProductResults() {
        assertTrue(homePage.Isempty());
    }
}
