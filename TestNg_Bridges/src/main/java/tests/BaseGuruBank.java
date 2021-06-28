package tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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


import pageobjects.GuruBank;

/*
 * Author: Neil Bridges Date: 6/28/2021
 *
 * Example of closes alerts
 *
 */
public class BaseGuruBank {

	
	String driverPath = "C:\\chromedriver.exe";
	

	GuruBank objGuruBank;
	
	WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports Reports;
	ExtentTest logger;
	
	
	
	@BeforeTest
	public void setup() {

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\src\\test\\Reports\\reports.html");
		Reports = new ExtentReports();
		Reports.attachReporter(htmlReporter);
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/popup.php/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	
	@Test(priority = 0)
	public void testOne() throws InterruptedException {
		logger = Reports.createTest("testOne");
		objGuruBank = new GuruBank(driver);
		objGuruBank.windowHandle();		
		logger.log(Status.PASS, "testOne");
		
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
