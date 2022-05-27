package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ClearCartSteps {

    HomePage homePage;

    public ClearCartSteps(HomePage homePage) {
        this.homePage = homePage;
    }

    @Given("homePage active")
    public void homepageActive() {
        assertTrue( homePage.haveLogo());
    }

    @When("user click on cart_icon")
    public void userClickOnCart_icon() {
        homePage.goToCart();
    }

    @And("delete items inside it")
    public void deleteItemsInsideIt() {
        //for (int i=0; i<homePage.getCartsize(); i++)
        homePage.deleteItem();
        //homePage.increaseQuant();
    }

    @Then("the items a no more visible")
    public void theItemsANoMoreVisible() {
        homePage.waitUntilOption();
        assertFalse(homePage.isEmptyMessage());
    }
}
