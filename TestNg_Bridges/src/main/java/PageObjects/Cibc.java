package PageObjects;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cibc {

	private final WebDriver driver;
	Actions action;
	WebDriverWait wait;
	WebElement element;
	

	// Page Object constructor which passes the driver context forward
	public Cibc(WebDriver driver) {
		this.driver = driver;
		action = new Actions(driver);
		wait = new WebDriverWait(driver, 30);

	}

	public void homePage() throws InterruptedException {

		element = driver.findElement(By.id("button-1543417624262"));
		action.click(element).build().perform();

		// Hover over Mortgages button show menu
		element = driver.findElement(By.id("Mortgages"));
		action.moveToElement(element).build().perform();
		Thread.sleep(4000);

		// Hover over Investments button show menu
		element = driver.findElement(By.id("Investments"));
		action.moveToElement(element).build().perform();
		
		Thread.sleep(4000);
	}

	By searchBox = By.name("qt");

	public CibcP2 typeSearchItem(String searchItem) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox)).isEnabled();
		driver.findElement(searchBox).sendKeys(searchItem);
		action.sendKeys(Keys.ENTER).build().perform();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		return new CibcP2(driver);
	}

}
