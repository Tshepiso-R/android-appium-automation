package com.sdet.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {
    
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Products']")
    private WebElement productsTitle;
    
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc='store item'])[1]")
    private WebElement firstProduct;
    
    public ProductsPage(AppiumDriver driver) {
        super(driver);
    }
    
    public boolean isProductsPageDisplayed() {
        return isDisplayed(productsTitle);
    }
    
    public String getProductsTitle() {
        return getText(productsTitle);
    }
    
    public void clickFirstProduct() {
        click(firstProduct);
    }
}
