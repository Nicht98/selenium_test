package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class addProductByName {
    HomePage homePage;

    public addProductByName(HomePage homePage) {
        this.homePage = homePage;

    }

    @Given("user at the Home")
    public void userAtTheHome() {
        assertTrue( homePage.haveLogo());
    }

    @When("select a product")
    public void selectAToCart() {
       homePage.hoverItem();

    }

    @And("add {string} to cart")
    public void addToCart(String productName) {
        homePage.addItemToCart(productName);
    }

    @Then("then the {string} is add to cart")
    public void theCartIsUpdate(String productName) {
        homePage.goToCart();
       assertTrue( homePage.isTheItemInTheCart(productName));
      
    }
}
