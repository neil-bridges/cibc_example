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


public class TwoInputField {

	public WebDriver driver;

	public TwoInputField(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// Inserts text into the text box
	public void InsertTextFields() {
		//Enter first field
		driver.findElement(By.xpath("//*[@id=\"sum1\"]")).sendKeys("5");
		//Second field
		driver.findElement(By.xpath("//*[@id=\"sum2\"]")).sendKeys("10");
	}

	// Click Get Total button
	public void GetTotalButton() {
     ///html/body/div[2]/div/div[2]/div[1]/div[2]/form/button
//		driver.findElement(By.xpath("//button[@class='btn btn-default' and contains(text(),'Show Message')]")).click();

		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/form/button")).click();
		
	}
	//User message gets shown
	public void TotalShown() {
	     ///html/body/div[2]/div/div[2]/div[1]/div[2]/form/button
//			driver.findElement(By.xpath("//button[@class='btn btn-default' and contains(text(),'Show Message')]")).click();

	String total = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div")).getText();
			System.out.println(total);
		}

}
