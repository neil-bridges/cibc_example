package tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import PageObjects.Cibc;
import PageObjects.CibcP2;
import PageObjects.Google;


/*
 * Author: Neil Bridges Date: 6/28/2021
 *
 * Page will Load Google input Cibc into search then click 
 * cibc link. Cibc page loads then accept the cookies. Will mouse hover
 * over dropdowns then input 'mortgage' into search bar and load that page.
 *
 */
public class BaseTest {

	String driverPath = "C:\\chromedriver.exe";

	WebDriver driver;
	Actions action;
	Cibc objCibc;
	CibcP2 objCibcP2;
	Google objGoogle;
	
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports Reports;
	ExtentTest logger;
	WebElement element;

	@BeforeTest
	public void setup() {

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\src\\test\\Reports\\reports.html");
		Reports = new ExtentReports();
		Reports.attachReporter(htmlReporter);
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test(priority = 0)
	public void testOne() throws InterruptedException {
		logger = Reports.createTest("testOne");
		objGoogle = new Google(driver);
	    objGoogle.typeSearchItem("cibc");
		objGoogle.cibcLinkClicked();
		logger.log(Status.PASS, "testOne");
	}

	@Test(priority = 1)
	public void testTwo() throws InterruptedException {
		logger = Reports.createTest("testTwo");
		objCibc = new Cibc(driver);
		objCibc.homePage();
		objCibcP2 = objCibc.typeSearchItem("mortgage");
		logger.log(Status.PASS, "testOne");
	}
	
	@Test(priority = 2)
	public void testThree() throws InterruptedException {
		logger = Reports.createTest("testThree");
		objCibcP2 = new CibcP2(driver);
		Assert.assertEquals(objCibcP2.returnPageTitle(), "Search Results");
		
    	logger.log(Status.PASS, "testThree");
	}
	
	@AfterMethod()
	public void afterTest(ITestResult Result) throws IOException {
		if (ITestResult.FAILURE == Result.getStatus()) {
			TakesScreenshot scrsht = (TakesScreenshot) driver;
			File SrcFile = scrsht.getScreenshotAs(OutputType.FILE);
			String dest = System.getProperty("user.dir") + "\\src\\test\\Reports\\SCREENSHOT_"
					+ Result.getMethod().getMethodName() + ".PNG";
			File DestnFile = new File(dest);
			FileUtils.copyFile(SrcFile, DestnFile);
			logger.log(Status.FAIL, Result.getThrowable());
			logger.log(Status.FAIL, "Snapshot below: " + logger.addScreenCaptureFromPath(dest));
		}
	}

	@AfterTest
	public void tearDown() throws InterruptedException {
		Reports.flush();
		driver.quit();
	}

}
