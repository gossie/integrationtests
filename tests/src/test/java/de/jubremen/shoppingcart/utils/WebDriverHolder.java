package de.jubremen.shoppingcart.utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;

public class WebDriverHolder {
    
    private static WebDriver driver;
    
    
    public static WebDriver getDriver() {
        if(driver == null) {
            String remoteSeleniumServer = getSystemPropertyValue("selenium.remote.server", null);
            int remoteSeleniumPort = Integer.valueOf(getSystemPropertyValue("selenium.remote.port", "4444")).intValue();
            
            if(remoteSeleniumServer == null) {
                driver = new FirefoxDriver();
            } else {
                try {
                    driver = new RemoteWebDriver(new URL("http", remoteSeleniumServer, remoteSeleniumPort, "/wd/hub"), DesiredCapabilities.firefox());
                } catch(MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        
        return driver;
    }
    
    
    private static String getSystemPropertyValue(String key, String defaultValue) {
        String value = System.getProperty(key);
        if(value == null) {
            return defaultValue;
        }
        return value;
    }

    
    @After(order = 1)
    public static void resetDriver() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }


    @After
    public void takeScreenshot(Scenario scenario) {
        if(scenario.isFailed()) {
            TakesScreenshot takesScreenshot;
            if(driver instanceof TakesScreenshot) {
                takesScreenshot = (TakesScreenshot) driver;
            } else {
                takesScreenshot = (TakesScreenshot) new Augmenter().augment(driver);
            }
            scenario.embed(takesScreenshot.getScreenshotAs(OutputType.BYTES), "image/png");
            ((WebDriver) takesScreenshot).close();
        }
    }
}
