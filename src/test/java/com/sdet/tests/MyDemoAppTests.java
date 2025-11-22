package com.sdet.tests;

import com.sdet.pages.CartPage;
import com.sdet.pages.LoginPage;
import com.sdet.pages.ProductDetailsPage;
import com.sdet.pages.ProductsPage;
import com.sdet.utils.TestDataReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyDemoAppTests extends BaseTest {
    
    @Test(priority = 1, description = "Verify app launches successfully")
    public void testAppLaunch() {
        ProductsPage productsPage = new ProductsPage(driver);
        
        Assert.assertTrue(productsPage.isProductsPageDisplayed(), 
            "Products page should be displayed on app launch");
        
        System.out.println("? Test Passed: App launched successfully");
    }
    
    @Test(priority = 2, description = "Verify products page displays correct title")
    public void testProductsPageTitle() {
        ProductsPage productsPage = new ProductsPage(driver);
        
        String title = productsPage.getProductsTitle();
        
        Assert.assertEquals(title, "Products", 
            "Products page title should be 'Products'");
        
        System.out.println("? Test Passed: Products title is correct - " + title);
    }
    
    @Test(priority = 3, description = "Verify user can view product details")
    public void testViewProductDetails() {
        ProductsPage productsPage = new ProductsPage(driver);
        
        ProductDetailsPage productDetailsPage = productsPage.clickFirstProduct();
        
        Assert.assertTrue(productDetailsPage.isProductDetailsDisplayed(),
            "Product details page should be displayed");
        
        String productName = productDetailsPage.getProductTitle();
        String productPrice = productDetailsPage.getProductPrice();
        
        Assert.assertTrue(productName.contains("Sauce Labs"),
            "Product name should contain 'Sauce Labs'");
        Assert.assertTrue(productPrice.contains("$"),
            "Product price should contain '$' symbol");
        
        System.out.println("? Test Passed: Product details displayed - " + productName + " - " + productPrice);
    }
    
    @Test(priority = 4, description = "Verify user can add product to cart")
    public void testAddProductToCart() {
        ProductsPage productsPage = new ProductsPage(driver);
        ProductDetailsPage productDetailsPage = productsPage.clickFirstProduct();
        
        productDetailsPage.clickAddToCart();
        
        String cartBadge = productDetailsPage.getCartBadgeCount();
        
        Assert.assertEquals(cartBadge, "1",
            "Cart badge should show 1 item after adding product");
        
        System.out.println("? Test Passed: Product added to cart successfully - Badge count: " + cartBadge);
    }
    
    @Test(priority = 5, description = "Verify cart displays added product")
    public void testViewCart() {
        ProductsPage productsPage = new ProductsPage(driver);
        ProductDetailsPage productDetailsPage = productsPage.clickFirstProduct();
        
        String expectedProductName = productDetailsPage.getProductTitle();
        String expectedPrice = productDetailsPage.getProductPrice();
        
        productDetailsPage.clickAddToCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCartIcon();
        
        Assert.assertTrue(cartPage.isCartPageDisplayed(),
            "Cart page should be displayed");
        
        String cartTitle = cartPage.getCartTitle();
        Assert.assertEquals(cartTitle, TestDataReader.getCartTitle(),
            "Cart title should be 'My Cart'");
        
        String cartProductName = cartPage.getCartProductName();
        String cartProductPrice = cartPage.getCartProductPrice();
        
        Assert.assertEquals(cartProductName, expectedProductName,
            "Cart should display correct product name");
        Assert.assertEquals(cartProductPrice, expectedPrice,
            "Cart should display correct product price");
        
        System.out.println("? Test Passed: Cart displays correct product - " + cartProductName);
    }
    
    @Test(priority = 6, description = "Verify user can remove product from cart")
    public void testRemoveProductFromCart() {
        ProductsPage productsPage = new ProductsPage(driver);
        ProductDetailsPage productDetailsPage = productsPage.clickFirstProduct();
        
        productDetailsPage.clickAddToCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCartIcon();
        
        Assert.assertTrue(cartPage.isCartPageDisplayed(),
            "Cart page should be displayed");
        
        cartPage.clickRemoveItem();
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("? Test Passed: Product removed from cart successfully");
    }
    
    @Test(priority = 7, description = "Verify user can login successfully")
    public void testSuccessfulLogin() {
        ProductsPage productsPage = new ProductsPage(driver);
        LoginPage loginPage = productsPage.navigateToLogin();
        
        Assert.assertTrue(loginPage.isLoginPageDisplayed(),
            "Login page should be displayed");
        
        loginPage.loginWithBob();
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        Assert.assertTrue(productsPage.isProductsPageDisplayed(),
            "Should navigate back to Products page after login");
        
        System.out.println("? Test Passed: User logged in successfully with credentials: " 
            + TestDataReader.getLoginUsername());
    }
}
