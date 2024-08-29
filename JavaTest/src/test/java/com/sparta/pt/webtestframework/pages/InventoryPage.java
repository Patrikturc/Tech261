package com.sparta.pt.webtestframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryPage {

    private final WebDriver webDriver;
    private final By inventoryItems = By.className("inventory_item");
    private final By shoppingCartBadge = By.className("shopping_cart_badge");
    private final By addToCartButton = By.className("btn_primary");

    public InventoryPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public List<WebElement> getInventoryItems() {
        return webDriver.findElements(inventoryItems);
    }

    public boolean isShoppingCartBadgePresent() {
        return !webDriver.findElements(shoppingCartBadge).isEmpty();
    }

    public Integer getCartCount() {
        return Integer.parseInt(webDriver.findElement(shoppingCartBadge).getText());
    }

    public void addItemToCart() {
        webDriver.findElements(addToCartButton).getFirst().click();
    }

}