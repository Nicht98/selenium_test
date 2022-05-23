package steps;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.HomePage;

public class HomeSteps {

    private HomePage homePage;

    public HomeSteps(HomePage homePage) {
        this.homePage = homePage;
    }

    @Then("Homepage is opened")
    public void homePageIsOpened() {
        Assert.assertTrue(homePage.haveLogo(), "This is not the home page");
    }
}
