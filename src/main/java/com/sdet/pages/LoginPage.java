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
    
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='bob@example.com']")
    private WebElement bobUsername;
    
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='10203040']")
    private WebElement bobPassword;
    
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Login']")
    private WebElement loginTitle;
    
    public LoginPage(AppiumDriver driver) {
        super(driver);
    }
    
    public boolean isLoginPageDisplayed() {
        return isDisplayed(loginTitle);
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
    
    public void clickBobUsername() {
        click(bobUsername);
    }
    
    public void clickBobPassword() {
        click(bobPassword);
    }
    
    public ProductsPage loginWithBob() {
        clickBobUsername();
        clickBobPassword();
        clickLogin();
        return new ProductsPage(driver);
    }
    
    public ProductsPage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
        return new ProductsPage(driver);
    }
}
