package com.sdet.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    
    @AndroidFindBy(accessibility = "Username input field")
    private WebElement usernameField;
    
    @AndroidFindBy(accessibility = "Password input field")
    private WebElement passwordField;
    
    @AndroidFindBy(accessibility = "Login button")
    private WebElement loginButton;
    
    @AndroidFindBy(xpath = "//*[contains(@text, 'Username is required')]")
    private WebElement usernameError;
    
    public LoginPage(AppiumDriver driver) {
        super(driver);
    }
    
    public void enterUsername(String username) {
        sendKeys(usernameField, username);
    }
    
    public void enterPassword(String password) {
        sendKeys(passwordField, password);
    }
    
    public void clickLogin() {
        click(loginButton);
    }
    
    public ProductsPage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
        return new ProductsPage(driver);
    }
    
    public boolean isUsernameErrorDisplayed() {
        return isDisplayed(usernameError);
    }
}
