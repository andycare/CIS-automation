package login
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

class Login {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("I am on login page")
	def I_am_on_login_page() {
		WebUI.openBrowser('');
		WebUI.navigateToUrl(GlobalVariable.TrainingUrl)
		WebUI.maximizeWindow()
	}

	@Given("I am stay on login page")
	def I_am_stay_on_login_page() {
		WebUI.navigateToUrl(GlobalVariable.TrainingUrl)
	}

	@When("I input admin userid")
	def I_input_admin_userid() {
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@type = 'text' and @placeholder = 'Username']"), GlobalVariable.user_admin)
	}

	@When("I input FO userid")
	def I_input_fo_userid() {
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@type = 'text' and @placeholder = 'Username']"), GlobalVariable.user_fo)
	}

	@When("I input doctor userid")
	def I_input_doctor_userid() {
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@type = 'text' and @placeholder = 'Username']"), GlobalVariable.user_dokter)
	}

	@When("I input nurse userid")
	def I_input_nurse_userid() {
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@type = 'text' and @placeholder = 'Username']"), GlobalVariable.user_nurse)
	}

	@When("I input pharmacy userid")
	def I_input_pharmacy_userid() {
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@type = 'text' and @placeholder = 'Username']"), GlobalVariable.user_pharmacy)
	}

	@And("I input correct password")
	def I_input_correct_password() {
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@type = 'password' and @placeholder = 'Password']"), GlobalVariable.password)
	}

	@And("I input correct FO password")
	def I_input_correct_fo_password() {
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@type = 'password' and @placeholder = 'Password']"), GlobalVariable.password_fo)
	}

	@And("I click login")
	def I_click_login() {
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[@type = 'submit' and (text() = 'Login' or . = 'Login')]"))
	}

	@Then("I can login into dashboard")
	def I_can_login_into_dashboard() {
		assert WebUI.verifyElementVisible(new TestObject().addProperty('class', ConditionType.EQUALS, "profile-name")) == true
	}
}