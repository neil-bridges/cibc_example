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
import PageObjects.TwoInputField;
import ConfigFileReader.ConfigFileReader;

public class TwoInputFieldSteps {
	public static WebDriver driver;

	TwoInputField objTwoInputField;
	ConfigFileReader fileReader;

	/*
	 * @Before public void setup(cucumber.api.Scenario scenario) {
	 * //System.out.println(scenario.getId().split(";")[0]); }
	 */

	@Given("^User enters value for all the required fields$")
	public void TwoInputFieldSteps() throws Throwable {
		fileReader = new ConfigFileReader();
		System.setProperty(fileReader.getDriverName(), fileReader.getDriverPath());
		driver = fileReader.getDriver();

		Reporter.addScenarioLog("Scenario Log message goes here");
		Reporter.addStepLog("This will run"); ///////////////// THIS WORKED
		driver.get(fileReader.getpageUrl());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(fileReader.getimplicitWait(), TimeUnit.SECONDS);
		objTwoInputField = new TwoInputField(driver);
		objTwoInputField.InsertTextFields();
		System.out.println("Text inserted");
	}

	@When("^Clicks on the Get total button$")
	public void Show_Message_Button_Entered() throws Throwable {
		System.out.println("Button Clicked");
		objTwoInputField.GetTotalButton();;
	}

	@Then("^Total Message gets shown$")
	public void TwoInputField() {
		System.out.println("Message Shown");
		objTwoInputField.TotalShown();		
	}

}
