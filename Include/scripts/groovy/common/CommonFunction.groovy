package common
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
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class CommonFunction {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("I already login as FO")
	def I_already_login_as_FO() {
		CucumberKW.runFeatureFileWithTags('Include/features/login/Login.feature', '@loginFO')
	}

	@Given("I already login as Admin")
	def I_already_login_as_admin() {
		CucumberKW.runFeatureFileWithTags('Include/features/login/Login.feature', '@loginAdmin')
	}

	@Given("I already login as Doctor")
	def I_already_login_as_doctor() {
		CucumberKW.runFeatureFileWithTags('Include/features/login/Login.feature', '@loginDoctor')
	}

	@Given("I already login as Nurse")
	def I_already_login_as_nurse() {
		CucumberKW.runFeatureFileWithTags('Include/features/login/Login.feature', '@loginNurse')
	}

	@Given("I already login as Pharmacy")
	def I_already_login_as_pharmacy() {
		CucumberKW.runFeatureFileWithTags('Include/features/login/Login.feature', '@loginPharmacy')
	}

	@And("I already logout")
	def I_already_logout_as_fo() {
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/Page_CIS Train/button_AutoFO'))
		WebUI.click(findTestObject('Object Repository/Page_CIS Train/button_Logout'))
	}

	@And("I already open FO page")
	def I_already_open_fo_page() {
		WebUI.click(findTestObject('FO/Patient/Patient Data/a_frontoffice'))
	}

	@And("I already open Medical Record page")
	def I_already_open_medical_record_page() {
		WebUI.click(findTestObject('Medical Record/a_medicalrecord'))
	}

	@And("I click next")
	def I_click_next() {
		WebUI.click(findTestObject('Object Repository/Page_CIS Train/button_next'))
	}

	@And("I click bulk delete")
	def I_click_bulk_delete() {
		WebUI.click(findTestObject('Object Repository/Page_CIS Train/button_bulk_delete'))
	}

	@And("I click save")
	def I_click_save() {
		WebUI.delay(2)
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[(text() = 'Save' or . = 'Save')]"))
	}
}