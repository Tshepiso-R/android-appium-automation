package com.sdet.tests;

import com.sdet.pages.LoginPage;
import com.sdet.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyDemoAppTests extends BaseTest {
    
    @Test(priority = 1, description = "Verify app launches successfully")
    public void testAppLaunch() {
        ProductsPage productsPage = new ProductsPage(driver);
        
        Assert.assertTrue(productsPage.isProductsPageDisplayed(), 
            "Products page should be displayed on app launch");
        
        System.out.println("Test Passed: App launched successfully");
    }
    
    @Test(priority = 2, description = "Verify products page displays correct title")
    public void testProductsPageTitle() {
        ProductsPage productsPage = new ProductsPage(driver);
        
        String title = productsPage.getProductsTitle();
        
        Assert.assertEquals(title, "Products", 
            "Products page title should be 'Products'");
        
        System.out.println("Test Passed: Products title is correct - " + title);
    }
    
    @Test(priority = 3, description = "Verify user can click on a product")
    public void testClickProduct() {
        ProductsPage productsPage = new ProductsPage(driver);
        
        Assert.assertTrue(productsPage.isProductsPageDisplayed(), 
            "Products page should be displayed");
        
        productsPage.clickFirstProduct();
        
        System.out.println("Test Passed: Successfully clicked on first product");
    }
}
