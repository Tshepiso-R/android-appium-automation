package com.sdet.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {
    
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My Cart']")
    private WebElement myCartTitle;
    
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Sauce Labs')]")
    private WebElement cartProductName;
    
    @AndroidFindBy(xpath = "(//android.widget.TextView[starts-with(@text, '$')])[1]")
    private WebElement cartProductPrice;
    
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Remove Item']")
    private WebElement removeItemButton;
    
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Proceed To Checkout']")
    private WebElement proceedToCheckoutButton;
    
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Total:')]")
    private WebElement totalLabel;
    
    @AndroidFindBy(accessibility = "cart badge")
    private WebElement cartIcon;
    
    public CartPage(AppiumDriver driver) {
        super(driver);
    }
    
    public boolean isCartPageDisplayed() {
        return isDisplayed(myCartTitle);
    }
    
    public String getCartTitle() {
        return getText(myCartTitle);
    }
    
    public String getCartProductName() {
        return getText(cartProductName);
    }
    
    public String getCartProductPrice() {
        return getText(cartProductPrice);
    }
    
    public void clickRemoveItem() {
        click(removeItemButton);
    }
    
    public void clickProceedToCheckout() {
        click(proceedToCheckoutButton);
    }
    
    public boolean isTotalDisplayed() {
        return isDisplayed(totalLabel);
    }
    
    public void clickCartIcon() {
        click(cartIcon);
    }
}
