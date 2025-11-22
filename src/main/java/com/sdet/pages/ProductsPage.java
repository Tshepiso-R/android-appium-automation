package com.sdet.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {
    
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Products']")
    private WebElement productsTitle;
    
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc='store item'])[1]")
    private WebElement firstProduct;
    
    @AndroidFindBy(accessibility = "open menu")
    private WebElement menuButton;
    
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Log In']")
    private WebElement loginMenuItem;
    
    @AndroidFindBy(accessibility = "cart badge")
    private WebElement cartIcon;
    
    public ProductsPage(AppiumDriver driver) {
        super(driver);
    }
    
    public boolean isProductsPageDisplayed() {
        return isDisplayed(productsTitle);
    }
    
    public String getProductsTitle() {
        return getText(productsTitle);
    }
    
    public ProductDetailsPage clickFirstProduct() {
        click(firstProduct);
        return new ProductDetailsPage(driver);
    }
    
    public void openMenu() {
        click(menuButton);
    }
    
    public LoginPage navigateToLogin() {
        openMenu();
        click(loginMenuItem);
        return new LoginPage(driver);
    }
    
    public CartPage clickCartIcon() {
        click(cartIcon);
        return new CartPage(driver);
    }
}
