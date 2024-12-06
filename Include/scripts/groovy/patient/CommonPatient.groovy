package patient

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

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

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.common.WebUiCommonHelper
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

import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW

import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import customkeyword.uploadFileKey
import customkeyword.DatepickerPatient
import customkeyword.click
import groovy.ui.SystemOutputInterceptor

import com.kms.katalon.core.main.CustomKeywordDelegatingMetaClass

import org.openqa.selenium.Keys as Keys


class CommonPatient {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	def patientno
	def patient = findTestData("Patient/Patient_data")
	def patient_address = findTestData("Patient/Patient_address")
	def patient_guarantor = findTestData("Patient/Patient_guarantor")
	String gender
	String salutation


	@Given("I am open patient page")
	def I_am_open_patient_page() {
		WebUI.click(findTestObject('FO/Patient/Patient Data/a_frontline'))

		WebUI.click(findTestObject('FO/Patient/Patient Data/a_patient'))
	}

	@Given("patient already created")
	def I_patient_already_created() {
		CucumberKW.runFeatureFileWithTags('Include/features/FO/Patient.feature', '@patient1')
	}

	@And("I search patient data")
	def I_search_patient_data() {
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='dropdown']/span"))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = 'Patient Phone' or . = 'Patient Phone')]"))

		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@type = 'text' and @placeholder = 'Birthdate / Phone No. / No']"), patient.getValue('no_hp', GlobalVariable.registrasi))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[(text() = 'Search' or . = 'Search')]"))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[(text() = 'Select' or . = 'Select')]"))
	}

	@And("I search patient on registration")
	def I_search_patient_on_registration() {
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='dropdown']/span"))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = 'Patient Phone' or . = 'Patient Phone')]"))

		WebUI.setText(findTestObject('Object Repository/FO/Registration/input_search_patient_regis'), patient.getValue('no_hp', GlobalVariable.registrasi))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[(text() = 'Search' or . = 'Search')]"))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[(text() = 'Select' or . = 'Select')]"))
	}

	@And("I open patient detail page")
	def I_open_patient_detail_page() {
		WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[(text() = 'Add' or . = 'Add')]"),0)
	}
}