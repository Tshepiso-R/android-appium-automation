package com.sdet.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestDataReader {
    
    private static Properties properties;
    
    static {
        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream("src/test/resources/testdata.properties");
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load test data properties file");
        }
    }
    
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
    
    // Login
    public static String getLoginUsername() {
        return properties.getProperty("login.username");
    }
    
    public static String getLoginPassword() {
        return properties.getProperty("login.password");
    }
    
    // Product
    public static String getProductName() {
        return properties.getProperty("product.name");
    }
    
    public static String getProductPrice() {
        return properties.getProperty("product.price");
    }
    
    // Cart
    public static String getCartTitle() {
        return properties.getProperty("cart.title");
    }
    
    // Shipping Address
    public static String getCheckoutFullName() {
        return properties.getProperty("checkout.fullname");
    }
    
    public static String getCheckoutAddress1() {
        return properties.getProperty("checkout.address1");
    }
    
    public static String getCheckoutAddress2() {
        return properties.getProperty("checkout.address2");
    }
    
    public static String getCheckoutCity() {
        return properties.getProperty("checkout.city");
    }
    
    public static String getCheckoutState() {
        return properties.getProperty("checkout.state");
    }
    
    public static String getCheckoutZipCode() {
        return properties.getProperty("checkout.zipcode");
    }
    
    public static String getCheckoutCountry() {
        return properties.getProperty("checkout.country");
    }
    
    // Payment
    public static String getCheckoutCardName() {
        return properties.getProperty("checkout.cardname");
    }
    
    public static String getCheckoutCardNumber() {
        return properties.getProperty("checkout.cardnumber");
    }
    
    public static String getCheckoutExpiration() {
        return properties.getProperty("checkout.expiration");
    }
    
    public static String getCheckoutSecurityCode() {
        return properties.getProperty("checkout.securitycode");
    }
    
    // Checkout Success
    public static String getCheckoutSuccessTitle() {
        return properties.getProperty("checkout.success.title");
    }
    
    public static String getCheckoutSuccessMessage() {
        return properties.getProperty("checkout.success.message");
    }
}
