package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.WhislistPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class NavigateToWhishlist {

    HomePage homePage;
    WhislistPage whislistPage;

    public NavigateToWhishlist(HomePage homePage, WhislistPage whislistPage) {
        this.homePage = homePage;
        this.whislistPage = whislistPage;
    }

    @Given("user at HomePage")
    public void userAtHomePage() {
        assertTrue( homePage.haveLogo());
    }

    @When("click on whilist button")
    public void clickOnWhilistButton() {
        homePage.hoverLogoIcon();
        homePage.goToWhislist();
    }

    @Then("whislist is displayed")
    public void whislistIsDisplayed() {
        assertEquals(whislistPage.getTitle(),"Mes Produits favoris");
    }
}
