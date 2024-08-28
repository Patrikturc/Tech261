package com.sparta.pt.webtestframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver webDriver;
    private By userNameField = new By.ByName("user-name");
    private By passwordField = new By.ByName("password");
    private By loginButton = new By.ById("login-button");

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

    public void enterUserName(String standardUser) {
        webDriver.findElement(userNameField).sendKeys(standardUser);
    }

    public String getErrorMessage() {
        return webDriver.findElement(By.cssSelector("[data-test='error']")).getText();
    }
}
