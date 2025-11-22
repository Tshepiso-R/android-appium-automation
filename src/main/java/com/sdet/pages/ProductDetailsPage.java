package com.sdet.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ProductDetailsPage extends BasePage {
    
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Sauce Labs')]")
    private WebElement productTitle;
    
    @AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text, '$')]")
    private WebElement productPrice;
    
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add To Cart']")
    private WebElement addToCartButton;
    
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='cart badge']/android.widget.TextView")
    private WebElement cartBadge;
    
    @AndroidFindBy(accessibility = "Increase item quantity")
    private WebElement increaseQuantityButton;
    
    @AndroidFindBy(accessibility = "Decrease item quantity")
    private WebElement decreaseQuantityButton;
    
    public ProductDetailsPage(AppiumDriver driver) {
        super(driver);
    }
    
    public boolean isProductDetailsDisplayed() {
        return isDisplayed(productTitle);
    }
    
    public String getProductTitle() {
        return getText(productTitle);
    }
    
    public String getProductPrice() {
        return getText(productPrice);
    }
    
    public void clickAddToCart() {
        click(addToCartButton);
    }
    
    public String getCartBadgeCount() {
        return getText(cartBadge);
    }
    
    public void increaseQuantity() {
        click(increaseQuantityButton);
    }
}
