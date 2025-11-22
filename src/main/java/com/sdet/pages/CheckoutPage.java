package com.sdet.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage {
    
    // Shipping Address Fields
    @AndroidFindBy(accessibility = "Full Name* input field")
    private WebElement fullNameField;
    
    @AndroidFindBy(accessibility = "Address Line 1* input field")
    private WebElement address1Field;
    
    @AndroidFindBy(accessibility = "Address Line 2 input field")
    private WebElement address2Field;
    
    @AndroidFindBy(accessibility = "City* input field")
    private WebElement cityField;
    
    @AndroidFindBy(accessibility = "State/Region input field")
    private WebElement stateField;
    
    @AndroidFindBy(accessibility = "Zip Code* input field")
    private WebElement zipCodeField;
    
    @AndroidFindBy(accessibility = "Country* input field")
    private WebElement countryField;
    
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='To Payment']")
    private WebElement toPaymentButton;
    
    // Payment Fields
    @AndroidFindBy(accessibility = "Full Name* input field")
    private WebElement cardNameField;
    
    @AndroidFindBy(accessibility = "Card Number* input field")
    private WebElement cardNumberField;
    
    @AndroidFindBy(accessibility = "Expiration Date* input field")
    private WebElement expirationDateField;
    
    @AndroidFindBy(accessibility = "Security Code* input field")
    private WebElement securityCodeField;
    
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Review Order']")
    private WebElement reviewOrderButton;
    
    // Review Order
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Review your order']")
    private WebElement reviewOrderTitle;
    
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Place Order']")
    private WebElement placeOrderButton;
    
    // Checkout Complete
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Checkout Complete']")
    private WebElement checkoutCompleteTitle;
    
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Thank you for your order']")
    private WebElement thankYouMessage;
    
    public CheckoutPage(AppiumDriver driver) {
        super(driver);
    }
    
    // Shipping Address Methods
    public void enterFullName(String fullName) {
        sendKeys(fullNameField, fullName);
    }
    
    public void enterAddress1(String address1) {
        sendKeys(address1Field, address1);
    }
    
    public void enterAddress2(String address2) {
        sendKeys(address2Field, address2);
    }
    
    public void enterCity(String city) {
        sendKeys(cityField, city);
    }
    
    public void enterState(String state) {
        sendKeys(stateField, state);
    }
    
    public void enterZipCode(String zipCode) {
        sendKeys(zipCodeField, zipCode);
    }
    
    public void enterCountry(String country) {
        sendKeys(countryField, country);
    }
    
    public void clickToPayment() {
        click(toPaymentButton);
    }
    
    public void fillShippingAddress(String fullName, String address1, String address2, 
                                    String city, String state, String zipCode, String country) {
        enterFullName(fullName);
        enterAddress1(address1);
        enterAddress2(address2);
        enterCity(city);
        enterState(state);
        enterZipCode(zipCode);
        enterCountry(country);
        clickToPayment();
    }
    
    // Payment Methods
    public void enterCardName(String cardName) {
        sendKeys(cardNameField, cardName);
    }
    
    public void enterCardNumber(String cardNumber) {
        sendKeys(cardNumberField, cardNumber);
    }
    
    public void enterExpirationDate(String expirationDate) {
        sendKeys(expirationDateField, expirationDate);
    }
    
    public void enterSecurityCode(String securityCode) {
        sendKeys(securityCodeField, securityCode);
    }
    
    public void clickReviewOrder() {
        click(reviewOrderButton);
    }
    
    public void fillPaymentDetails(String cardName, String cardNumber, 
                                   String expirationDate, String securityCode) {
        enterCardName(cardName);
        enterCardNumber(cardNumber);
        enterExpirationDate(expirationDate);
        enterSecurityCode(securityCode);
        clickReviewOrder();
    }
    
    // Review Order Methods
    public boolean isReviewOrderDisplayed() {
        return isDisplayed(reviewOrderTitle);
    }
    
    public void clickPlaceOrder() {
        click(placeOrderButton);
    }
    
    // Checkout Complete Methods
    public boolean isCheckoutCompleteDisplayed() {
        return isDisplayed(checkoutCompleteTitle);
    }
    
    public String getCheckoutCompleteTitle() {
        return getText(checkoutCompleteTitle);
    }
    
    public String getThankYouMessage() {
        return getText(thankYouMessage);
    }
}
