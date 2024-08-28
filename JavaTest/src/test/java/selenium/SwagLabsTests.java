package selenium;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class SwagLabsTests extends BaseTest {
    private static final String BASE_URL = "https://www.saucedemo.com/";

    @Test
    @DisplayName("Check that the webdriver works")
    public void checkWebDriver() {
        webDriver.get(BASE_URL);
        Assertions.assertEquals(BASE_URL, webDriver.getCurrentUrl());
        Assertions.assertEquals("Swag Labs", webDriver.getTitle());
    }

    @Test
    @DisplayName("Given that I enter a correct username but invalid password, When I click login, Then I should see an error message containing epic sadface")
    public void checkErrorMessageWhenInvalidPassword() {
        webDriver.get(BASE_URL);
        performLogin("standard_user", "wrong_password");
        WebElement errorMessage = webDriver.findElement(By.cssSelector("[data-test='error']"));
        MatcherAssert.assertThat(errorMessage.getText(), Matchers.containsString("Epic sadface"));
    }

    @Test
    @DisplayName("Given I enter a valid username and password, when I click login, then I should land on the inventory page")
    public void successfulLogin() {
        Wait<WebDriver> webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        webDriver.get(BASE_URL);
        performLogin("standard_user", "secret_sauce");
        webDriverWait.until(driver -> driver.getCurrentUrl().contains("/inventory"));

        MatcherAssert.assertThat(webDriver.getCurrentUrl(), Matchers.is(BASE_URL + "inventory.html"));
    }

    @Test
    @DisplayName("Given I am logged in, when I view the inventory page, I should see the correct number of products")
    public void checkNumberOfProductsOnInventoryPage() throws IOException {
        webDriver.get(BASE_URL);
        performLogin("standard_user", "secret_sauce");
        List<WebElement> items = webDriver.findElements(By.className("inventory_item"));
        int itemsCount = items.size();

        try (PrintWriter writer = new PrintWriter(new FileWriter("products.txt"))) {
            for (WebElement item : items) {
                WebElement nameElement = item.findElement(By.className("inventory_item_name"));
                WebElement priceElement = item.findElement(By.className("inventory_item_price"));
                String itemInfo = nameElement.getText() + ": " + priceElement.getText();
                writer.println(itemInfo);
                System.out.println(itemInfo);
            }
        }

        MatcherAssert.assertThat(itemsCount, Matchers.is(6));
    }

    @Test
    @DisplayName("Window handles")
    public void windowHandlesTest() {
        webDriver.get("https://news.ycombinator.com/");
        String originalWindow = webDriver.getWindowHandle();
        System.out.println(originalWindow);
        webDriver.findElement(By.linkText("new")).sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));

        Set<String> allWindows = webDriver.getWindowHandles();
        System.out.println(allWindows);

        // Switch the new tab (or at least one that is not this one)
        for (String tab : allWindows) {
            if (!tab.equals(originalWindow)) {
                webDriver.switchTo().window(tab);
            }
        }
    }

    // Private helper method to perform login
    private void performLogin(String username, String password) {
        WebElement usernameField = webDriver.findElement(By.name("user-name"));
        WebElement passwordField = webDriver.findElement(By.name("password"));
        WebElement loginButton = webDriver.findElement(By.id("login-button"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}
