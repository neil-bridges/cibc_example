package StepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import PageObjects.SingleInputField;
import ConfigFileReader.ConfigFileReader;

public class SingleInputFieldSteps {
	public static WebDriver driver;

	SingleInputField objSingleInputField;
	ConfigFileReader fileReader;

	/*
	 * @Before public void setup(cucumber.api.Scenario scenario) {
	 * //System.out.println(scenario.getId().split(";")[0]); }
	 */

	@Given("^Message gets entered$")
	public void SingleInputFieldSteps() throws Throwable {
		fileReader = new ConfigFileReader();
		System.setProperty(fileReader.getDriverName(), fileReader.getDriverPath());
		driver = fileReader.getDriver();

		Reporter.addScenarioLog("Scenario Log message goes here");
		Reporter.addStepLog("This will run"); ///////////////// THIS WORKED
		driver.get(fileReader.getpageUrl());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(fileReader.getimplicitWait(), TimeUnit.SECONDS);
		objSingleInputField = new SingleInputField(driver);
		objSingleInputField.InsertText();
		System.out.println("Text inserted");
	}

	@When("^Show message button entered	$")
	public void Show_Message_Button_Entered() throws Throwable {
		System.out.println("Button Clicked");
		objSingleInputField.ShowMessageButton();
	}

	@Then("^Message gets shown$")
	public void SingleInputField() {
		System.out.println("Message Shown");
		objSingleInputField.MessageShown();
		;
	}

}
