package com.sparta.pt.webtestframework.tests;

import com.sparta.pt.webtestframework.pages.HomePage;
import com.sparta.pt.webtestframework.pages.InventoryPage;
import com.sparta.pt.webtestframework.pages.Website;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.*;

import static org.hamcrest.Matchers.*;

public class SwagLabsTests extends TestSetup {
    private static final String BASE_URL = "https://www.saucedemo.com/";
    private Website website;
    private HomePage homePage;
    private InventoryPage inventoryPage;

    @BeforeEach
    public void setupPages() {
        website = getWebsite(BASE_URL);
        homePage = website.getHomePage();
    }

    @Test
    @DisplayName("Given I enter a valid username and password, when I click login, then I should land on the inventory page")
    public void successfulLogin() {
        homePage.successfulLoginAsStandardUser();
        MatcherAssert.assertThat(website.getCurrentUrl(), is(BASE_URL + "inventory.html"));
    }

    @Test
    @DisplayName("Given I enter a valid username and an invalid password, when I click login, then I should see an error message containing 'Epic sadface'")
    public void unsuccessfulLoginTest_InvalidPassword() {
        homePage.enterUserName("standard_user");
        homePage.enterPassword("invalid");
        homePage.clickLoginButton();
        MatcherAssert.assertThat(homePage.getErrorMessage(), containsString("Epic sadface"));
    }

    @Test
    @DisplayName("Given I am logged in, when I view the inventory page, I should see 6 items")
    public void checkNumberOfProductsOnInventoryPage() {
        inventoryPage = website.getInventoryPage();
        homePage.successfulLoginAsStandardUser();
        MatcherAssert.assertThat(inventoryPage.getInventoryItems().size(), is(6));
    }

    @Test
    @DisplayName("Given I am logged in, when I am on the inventory page, Then adding an item to the cart should increase the cart count by 1")
    public void addProductToCart() {
        inventoryPage = website.getInventoryPage();
        homePage.successfulLoginAsStandardUser();
        inventoryPage.addItemToCart();
        int initialCartCount = inventoryPage.isShoppingCartBadgePresent() ? inventoryPage.getCartCount() : 0;
        inventoryPage.addItemToCart();
        int updatedCartCount = inventoryPage.getCartCount();
        MatcherAssert.assertThat(updatedCartCount, is(initialCartCount + 1));
        System.out.println("Initial cart count: " + initialCartCount + ", Updated cart count: " + updatedCartCount);
    }
}