package com.sdet.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    
    protected AppiumDriver driver;
    
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        
        options.setPlatformName("Android");
        options.setDeviceName("emulator-5554");
        options.setAppPackage("com.saucelabs.mydemoapp.rn");
        options.setAppActivity(".MainActivity");
        options.setAutomationName("UiAutomator2");
        options.setNoReset(false);
        options.setFullReset(false);
        
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        System.out.println("App launched successfully on emulator");
    }
    
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Driver closed");
        }
    }
}
