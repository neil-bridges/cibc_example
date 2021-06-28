package pageobjects;

/*
 * Author: Neil Bridges Date: 6/28/2021
 *
 * Cibc page loaded from search bar within the Cibc homepage.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CibcP2 {

	private final WebDriver driver;
	Actions action;
	WebDriverWait wait;
	WebElement element;

	public CibcP2(WebDriver driver) {
		this.driver = driver;
		action = new Actions(driver);
		wait = new WebDriverWait(driver, 30);
		
	}

	public String returnPageTitle() {
		return driver.getTitle();
	}

}
