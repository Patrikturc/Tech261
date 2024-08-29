package com.sparta.pt.webtestframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private final WebDriver webDriver;
    private final By userNameField = new By.ByName("user-name");
    private final By passwordField = new By.ByName("password");
    private final By loginButton = new By.ById("login-button");
    private final By errorMessage = new By.ByCssSelector("[data-test='error']");

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterUsername(String username) {
        webDriver.findElement(this.userNameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        webDriver.findElement(this.passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        webDriver.findElement(this.loginButton).click();
    }

    public void successfulLoginAsStandardUser() {
        webDriver.findElement(userNameField).sendKeys("standard_user");
        webDriver.findElement(passwordField).sendKeys("secret_sauce");
        webDriver.findElement(loginButton).click();
    }

    public void enterUserName(String standardUser) {
        webDriver.findElement(userNameField).sendKeys(standardUser);
    }

    public String getErrorMessage() {
        return webDriver.findElement(errorMessage).getText();
    }
}
