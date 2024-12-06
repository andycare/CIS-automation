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



class PatientAddress {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */

	def patientno
	def patient = findTestData("Patient/Patient_data")
	def patient_address = findTestData("Patient/Patient_address")
	int rows_count
	int seq = GlobalVariable.Patient_address

	@When("I click add address")
	def I_click_add_address() {
		WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[(text() = 'Add' or . = 'Add')]"), 0)

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[(text() = 'Add' or . = 'Add')]"))
	}

	@And("I select address")
	def I_select_address() {
		WebUI.click(findTestObject('Object Repository/FO/Patient/Patient Address/button_Select_address'))
	}

	@And("I edit address data")
	def I_edit_address() {
		WebUI.enhancedClick(findTestObject('Object Repository/FO/Patient/Patient Address/dropdown_AddressType'))

		WebUI.enhancedClick(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+patient_address.getValue('address_type', seq)+"' or . = '"+patient_address.getValue('address_type', seq)+"')]"))

		WebUI.clearText(findTestObject('Object Repository/FO/Patient/Patient Address/textarea_address'))

		WebUI.setText(findTestObject('Object Repository/FO/Patient/Patient Address/textarea_address'), patient_address.getValue('address', seq))
	}

	@And("I input all address field")
	def I_input_all_address_field() {
		WebUI.enhancedClick(findTestObject('Object Repository/FO/Patient/Patient Address/dropdown_AddressType'))

		WebUI.enhancedClick(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+patient_address.getValue('address_type', GlobalVariable.Patient_address)+"' or . = '"+patient_address.getValue('address_type', GlobalVariable.Patient_address)+"')]"))

		WebUI.setText(findTestObject('Object Repository/FO/Patient/Patient Address/textarea_address'), patient_address.getValue('address', GlobalVariable.Patient_address))

		WebUI.scrollToElement(findTestObject('Object Repository/FO/Patient/Patient Address/dropdown_province'), 0)

		WebUI.enhancedClick(findTestObject('Object Repository/FO/Patient/Patient Address/dropdown_province'))

		WebUI.enhancedClick(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+patient_address.getValue('province', GlobalVariable.Patient_address)+"' or . = '"+patient_address.getValue('province', GlobalVariable.Patient_address)+"')]"))

		//WebUI.focus(findTestObject('Object Repository/FO/Patient/Patient Address/button_search'))

		WebUI.waitForElementClickable(findTestObject('Object Repository/FO/Patient/Patient Address/button_search'),15)

		WebUI.click(findTestObject('Object Repository/FO/Patient/Patient Address/button_search'))

		WebUI.delay(4)

		WebUI.setText(findTestObject('Object Repository/FO/Patient/Patient Address/txt_SearchDistrict'), patient_address.getValue('district', GlobalVariable.Patient_address))

		//WebUI.focus(findTestObject('Object Repository/FO/Patient/Patient Address/button_search2'))

		WebUI.waitForElementClickable(findTestObject('Object Repository/FO/Patient/Patient Address/button_search2'),10)

		WebUI.enhancedClick(findTestObject('Object Repository/FO/Patient/Patient Address/button_search'))

		WebUI.waitForElementClickable(findTestObject('Object Repository/FO/Patient/Patient Address/button_Select_zipcode'),15)

		WebUI.click(findTestObject('Object Repository/FO/Patient/Patient Address/button_Select_zipcode'))

		WebUI.setText(findTestObject('Object Repository/FO/Patient/Patient Address/txt_rt'), patient_address.getValue('rt', GlobalVariable.Patient_address))

		WebUI.setText(findTestObject('Object Repository/FO/Patient/Patient Address/txt_rw'), patient_address.getValue('rw', GlobalVariable.Patient_address))

		WebUI.setText(findTestObject('Object Repository/FO/Patient/Patient Address/txt_phoneno'), patient_address.getValue('phone_no', GlobalVariable.Patient_address))
	}

	@And("I click save address")
	def I_click_save_address() {
		WebUI.waitForElementClickable(findTestObject('Object Repository/FO/Patient/Patient Address/button_Save'),15)
		WebUI.click(findTestObject('Object Repository/FO/Patient/Patient Address/button_Save'))
	}

	@Then("Address succesfully added")
	def address_succesfully_added() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/FO/Patient/Patient Address/popup_success_save'), 25)
		def text = WebUI.getText(findTestObject('Object Repository/FO/Patient/Patient Address/popup_success_save'))
		WebUI.verifyMatch(text, 'Your form has been saved', true)
		WebUI.closeBrowser()
	}

	@Then("Address succesfully updated")
	def address_succesfully_updated() {
		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h2[@id = 'swal2-title' and (text() = 'Your document has been saved' or . = 'Your document has been saved')]"), 20)
		def text = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h2[@id = 'swal2-title' and (text() = 'Your document has been saved' or . = 'Your document has been saved')]"))
		WebUI.verifyMatch(text, 'Your document has been saved', true)
		WebUI.closeBrowser()
	}
}