package Runners;

import java.io.File;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openxml4j.opc.internal.FileHelper;
import org.testng.annotations.AfterMethod;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)				
@CucumberOptions
(
features="Features",
glue={"StepDefinitions"}, 
monochrome = true,
plugin = { "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:output/report.html"},
format = {"pretty", "html:target/cucumber"}
)						
public class TestRunner 				
{

@AfterClass
public static void teardown() 
{
Reporter.loadXMLConfig(new File("target/extent-config.xml"));
Reporter.setSystemInfo("user", System.getProperty("user.name"));
Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
Reporter.setTestRunnerOutput("Sample test runner output message");

}

@AfterMethod
public void after() throws InterruptedException
{
	Thread.sleep(10000);
}
}

