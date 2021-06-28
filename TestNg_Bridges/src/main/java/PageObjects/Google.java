package PageObjects;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Google {

	private final WebDriver driver;
	Actions action;
	WebDriverWait wait;
	WebElement element;

	public Google(WebDriver driver) {
		this.driver = driver;
		action = new Actions(driver);
		wait = new WebDriverWait(driver, 30);
		if (!driver.getTitle().equals("Google")) {
			throw new IllegalStateException(
					"This is not the correct page," + " current page is: " + driver.getCurrentUrl());
		}
	}

	By searchBox = By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input");

	public void typeSearchItem(String searchItem) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox)).isEnabled();
		driver.findElement(searchBox).sendKeys(searchItem);
		action.sendKeys(Keys.ENTER).build().perform();

	}

	public void cibcLinkClicked() throws InterruptedException {
		
		Thread.sleep(4000);

		// Click CIBC link in google
		element = driver.findElement(By.className("yuRUbf"));
			
		action.click(element).build().perform();
	}

}
