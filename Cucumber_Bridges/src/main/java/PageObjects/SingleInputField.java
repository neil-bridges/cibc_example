package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;



/*
*Author: Neil Bridges
*Date: 6/28/2021
*
*
*
*/


public class SingleInputField {

	public WebDriver driver;

	public SingleInputField(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Inserts text into the text box
	public void InsertText() {
		
		driver.findElement(By.xpath("//*[@id=\"user-message\"]")).sendKeys("room decor");
	}

	// Click Show Message button
	public void ShowMessageButton() {
     ///html/body/div[2]/div/div[2]/div[1]/div[2]/form/button
//		driver.findElement(By.xpath("//button[@class='btn btn-default' and contains(text(),'Show Message')]")).click();

		driver.findElement(By.className("btn btn-default")).click();
		
	}
	//User message gets shown
	public void MessageShown() {
	     ///html/body/div[2]/div/div[2]/div[1]/div[2]/form/button
//			driver.findElement(By.xpath("//button[@class='btn btn-default' and contains(text(),'Show Message')]")).click();

	String userMessage = driver.findElement(By.xpath("//*[@id=\"user-message\"]")).getText();
			System.out.println(userMessage);
		}

}
