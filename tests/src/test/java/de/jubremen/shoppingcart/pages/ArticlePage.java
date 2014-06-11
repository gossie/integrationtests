package de.jubremen.shoppingcart.pages;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ArticlePage extends AbstractPage {
	
	@FindBy(id="main:searchField")
	private WebElement searchField;
	@FindBy(id="main:searchButton")
	private WebElement searchButton;
	
	private WebElement totalPrice;
	

	public ArticlePage() {
		super();
	}

	
	public void searchForArticles(String name) {
		searchField.clear();
		searchField.sendKeys(name);
		searchButton.click();
		waitForResponse();
	}


	public void addArticle(String name) {
		WebElement addButton = driver.findElement(By.xpath("//td[text()=\"" + name + "\"]/..//a[text()=\"Hinzufügen\"]"));
		addButton.click();
		waitForResponse();
	}

	@Override
	protected void load() {
		driver.get("http://" + System.getProperty("application.remote.server") + ":" + System.getProperty("application.remote.port") + "/" + System.getProperty("application.remote.context") + "/articles.xhtml");
	}

	@Override
	protected void isLoaded() throws Error {
		assertThat(driver.getCurrentUrl(), containsString("articles.xhtml"));
	}


	public double getTotalPrice() {
		return Double.parseDouble(totalPrice.getText());
	}
}
