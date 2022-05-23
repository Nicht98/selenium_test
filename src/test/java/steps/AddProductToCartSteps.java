package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;

import static org.testng.Assert.assertTrue;

public class AddProductToCartSteps {
    HomePage homePage;

    public AddProductToCartSteps(HomePage homePage) {
        this.homePage = homePage;
    }
        @Given("^user at the HomePage$")
        public void userAtHomePage(){
           assertTrue( homePage.haveLogo());
        }

    @When("select a product to cart")
    public void add_a_product_to_cart() {
        homePage.selectProduct();

    }
    @And("add to cart")
    public void add_to_cart() {
        homePage.addToCart();
    }
    @Then("^the cart is update$")
    public void theCartIsUpdate (){
        homePage.goToCart();
        //assertTrue(homePage.isCartPageEmpty());
        }

}
