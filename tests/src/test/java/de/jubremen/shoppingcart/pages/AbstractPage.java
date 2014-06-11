package de.jubremen.shoppingcart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import de.jubremen.shoppingcart.utils.WebDriverHolder;

public abstract class AbstractPage extends LoadableComponent<AbstractPage> {
	
	protected static WebDriver driver;
	
	public AbstractPage() {
		driver = WebDriverHolder.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	protected void waitForResponse() {
		Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay")));
	}
}
