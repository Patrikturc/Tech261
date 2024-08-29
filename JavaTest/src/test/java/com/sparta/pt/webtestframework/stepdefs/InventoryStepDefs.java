package com.sparta.pt.webtestframework.stepdefs;

import com.sparta.pt.webtestframework.pages.HomePage;
import com.sparta.pt.webtestframework.pages.InventoryPage;
import com.sparta.pt.webtestframework.pages.Website;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InventoryStepDefs {

    private static Website website;
    private static HomePage homePage;
    private static InventoryPage inventoryPage;

    private static final String BASE_URL = "https://www.saucedemo.com";

    @After
    public void afterEach() {
        TestSetup.quitWebdriver();
        TestSetup.stopService();
    }

    @Before
    public static void setup() throws Exception {
        TestSetup.startChromeService();
        TestSetup.createWebDriver();
        website = TestSetup.getWebsite(BASE_URL);
        homePage = website.getHomePage();
        inventoryPage = website.getInventoryPage();

    }

    @Given("I am logged in")
    public void iAmLoggedIn() {
        homePage.successfulLoginAsStandardUser();
    }

    @When("I am on the inventory page")
    public void iAmOnTheInventoryPage() {
        inventoryPage = website.getInventoryPage();
    }

    @Then("I should see {int} items")
    public void iShouldSeeItems(int expected) {
        int actual = inventoryPage.getInventoryItems().size();
        assert expected == actual;
    }

    @And("I add an item to the basket")
    public void iAddAnItemToTheBasket() {
        inventoryPage.addItemToCart();
    }

    @Then("the number of items in the basket should be {int}")
    public void theNumberOfItemsInTheBasketShouldBe(int cartCount) {
        int actual = inventoryPage.getCartCount();
        assert cartCount == actual;
    }
}
