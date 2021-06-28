package pageobjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GuruBank {

	private final WebDriver driver;
	Actions action;
	WebDriverWait wait;
	Alert alert;

	public GuruBank(WebDriver driver) {
		this.driver = driver;
		action = new Actions(driver);
		wait = new WebDriverWait(driver, 30);
		if (!driver.getCurrentUrl().equals("http://demo.guru99.com/popup.php/")) {
			throw new IllegalStateException(
					"This is not the correct page," + " current page is: " + driver.getCurrentUrl());
		}
		driver.findElement(By.xpath("/html/body/p/a")).click();
	}
	


    
	
	public void windowHandle() {
		
		   String MainWindow=driver.getWindowHandle();		
   		
	        // To handle all new opened window.				
	            Set<String> s1=driver.getWindowHandles();		
	        Iterator<String> i1=s1.iterator();		
	        		
	        while(i1.hasNext())			
	        {		
	            String ChildWindow=i1.next();		
	            		
	            if(!MainWindow.equalsIgnoreCase(ChildWindow))			
	            {    		
	                 
	                    // Switching to Child window
	                    driver.switchTo().window(ChildWindow);	                                                                                                           
	                    driver.findElement(By.name("emailid"))
	                    .sendKeys("nb@test.com");                			
	                    
	                    driver.findElement(By.name("btnLogin")).click();			
	                                 
				// Closing the Child Window.
	                        driver.close();		
	            }		
	        }		
	        // Switching to Parent window i.e Main Window.
	            driver.switchTo().window(MainWindow);				
	    }
	}
	
	

