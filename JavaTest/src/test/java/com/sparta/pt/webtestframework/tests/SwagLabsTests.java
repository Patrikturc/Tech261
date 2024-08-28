package com.sparta.pt.webtestframework.tests;

import com.sparta.pt.webtestframework.pages.Website;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.*;

import static org.hamcrest.Matchers.is;

public class SwagLabsTests extends TestSetup {
    private static final String BASE_URL = "https://www.saucedemo.com/";
    private Website website;


//    @Test
//    @DisplayName("Check that the webdriver works")
//    public void checkWebDriver(){
//        webDriver.get(BASE_URL);
//        Assertions.assertEquals(BASE_URL, webDriver.getCurrentUrl());
//        Assertions.assertEquals("Swag Labs", webDriver.getTitle());
//    }

    @Test
    @DisplayName("Given I enter a valid username and password, when I click login, then I should land on the inventory page")
    public void successfulLogin(){
        website = getWebsite(BASE_URL);
        website.getHomePage().enterUserName("standard_user");
        website.getHomePage().enterPassword("secret_sauce");
        website.getHomePage().clickLoginButton();
        MatcherAssert.assertThat(website.getCurrentUrl(), is(BASE_URL + "inventory.html"));
    }

    @Test
    @DisplayName("Given I enter a valid username and an invalid password, when I click login, then I should see an error message containing 'Epic sadface'")
    public void unsuccessfulLoginTest_InvalidPassword(){
        website = getWebsite(BASE_URL);
        website.getHomePage().enterUserName("standard_user");
        website.getHomePage().enterPassword("invalid");
        website.getHomePage().clickLoginButton();
        MatcherAssert.assertThat(website.getHomePage().getErrorMessage(), is("Epic sadface: Username and password do not match any user in this service"));
    }


//    @Test
//    @DisplayName("Given I am logged in, when I view the inventory page, I should see the correct number of products")
//    public void checkNumberOfProductsOnInventoryPage() throws IOException {
//        webDriver.get(BASE_URL);
//        WebElement usernameField = webDriver.findElement(By.name("user-name"));
//        WebElement passwordField = webDriver.findElement(By.name("password"));
//        WebElement loginButton = webDriver.findElement(By.id("login-button"));
//        usernameField.sendKeys("standard_user");
//        passwordField.sendKeys("secret_sauce");
//        loginButton.click();
//        List<WebElement> items = webDriver.findElements(By.className("inventory_item"));
//        int itemsCount = items.size();
//
//        try(PrintWriter writer = new PrintWriter(new FileWriter("products.txt"))){
//            for(WebElement item : items){
//                WebElement nameElement = item.findElement(By.className("inventory_item_name"));
//                WebElement priceElement = item.findElement(By.className("inventory_item_price"));
//                String itemInfo = nameElement.getText() + ": " + priceElement.getText();
//                writer.println(itemInfo);
//                System.out.println(itemInfo);
//            }
//        }
//
//        MatcherAssert.assertThat(itemsCount, is(6));
//    }
//
//    @Test
//    @DisplayName("Window handles")
//    public void windowHandlesTest(){
//        webDriver.get("https://news.ycombinator.com/");
//        String originalTab = webDriver.getWindowHandle();
//        System.out.println(originalTab);
//        webDriver.findElement(By.linkText("new")).sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
//
//        Set<String> allWindows = webDriver.getWindowHandles();
//        System.out.println(allWindows);
//
//        // switch the new tab (or at least one that is not this one)
//        for(String tab : allWindows){
//            if(!originalTab.equals(tab)){
//                webDriver.switchTo().window(tab);
//                break;
//            }
//        }
//    }
//    @Test
//    @DisplayName("Given I am on the Drag and Drop page, when I drag Box A to Box B, then the boxes have switched positions")
//    public void dragAndDropTests() throws InterruptedException {
//        // Set up ChromeDriver
//
//        // Navigate to the page
//        webDriver.get("https://demoqa.com/droppable/");
//
//        // Find elements for dragging and dropping
//        WebElement columnA = webDriver.findElement(By.id("draggable"));
//        WebElement columnB = webDriver.findElement(By.id("droppable"));
//
//        // Perform drag and drop action
//        Actions action = new Actions(webDriver);
//        action.dragAndDrop(columnA, columnB).perform();
//
//        // Assert that the text of columnB has changed to "Dropped!"
//        MatcherAssert.assertThat(columnB.getText(), is("Dropped!"));
//
//    }
//    @Test
//    @DisplayName("Given I enter a valid username and an invalid password, when I click login, then I should see an error message containing 'Epic sadface'")
//    public void unsuccessfulLoginTest_InvalidPassword(){
//        webDriver.get(BASE_URL);
//        WebElement usernameField= webDriver.findElement(By.name("user-name"));
//        WebElement passwordField= webDriver.findElement(By.name("password"));
//        WebElement loginButton= webDriver.findElement(By.id("login-button"));
//        usernameField.sendKeys("standard_user");
//        passwordField.sendKeys("invalid");
//        loginButton.click();
//        WebElement alert = webDriver.findElement(By.className("error-message-container")).findElement(By.tagName("h3"));
//        MatcherAssert.assertThat(alert.getText(), containsString("Epic sadface"));
//    }
}