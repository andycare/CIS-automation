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


class AddPatient {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	def patientno
	def patient = findTestData("Patient/Patient_data")
	def patient_address = findTestData("Patient/Patient_address")
	def patient_guarantor = findTestData("Patient/Patient_guarantor")
	String gender
	String salutation

	@When("I click add patient")
	def I_click_add() {
		WebUI.click(findTestObject('FO/Patient/Patient Data/btn_add'))
	}

	@And("I input all field")
	def I_input_all_field() {

		WebUI.scrollToElement(findTestObject('FO/Patient/Patient Data/label_sourcefrom'), 5)

		WebUI.click(findTestObject('FO/Patient/Patient Data/dropdown_salutation'))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+patient.getValue('Salutation', GlobalVariable.patient_data)+"' or . = '"+patient.getValue('Salutation', GlobalVariable.patient_data)+"')]"))

		salutation = WebUI.getText(findTestObject('Object Repository/FO/Patient/Patient Data/dropdown_salutation'))

		WebUI.setText(findTestObject('Object Repository/FO/Patient/Patient Data/txt_firstname'), patient.getValue('Patient_First_Name', GlobalVariable.patient_data))

		WebUI.setText(findTestObject('Object Repository/FO/Patient/Patient Data/txt_middlename'), patient.getValue('Patient_Middle_Name', GlobalVariable.patient_data))

		WebUI.setText(findTestObject('Object Repository/FO/Patient/Patient Data/txt_lastname'), patient.getValue('Patient_Last_Name', GlobalVariable.patient_data))

		WebUI.focus(findTestObject('Object Repository/FO/Patient/Patient Data/txt_birthdate'))
		WebUI.delay(2)

		WebElement Tgl_Lahir = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/FO/Patient/Patient Data/txt_birthdate'),10)

		WebUI.executeJavaScript("arguments[0].value='"+patient.getValue('Birthdate', GlobalVariable.patient_data)+"'", Arrays.asList(Tgl_Lahir))

		//WebUI.setText(findTestObject('Object Repository/FO/Patient/Patient Data/txt_birthdate'), patient.getValue('Birthdate', 1))

		WebUI.focus(findTestObject('Object Repository/FO/Patient/Patient Data/txt_birthplace'))

		WebUI.setText(findTestObject('Object Repository/FO/Patient/Patient Data/txt_birthplace'), patient.getValue('Birthplace', GlobalVariable.patient_data))

		WebUI.scrollToElement(findTestObject('Object Repository/FO/Patient/Patient Data/txt_birthdate'), 5)

		//update cek gender auto filled based on salutation
		if(salutation == 'Mr.') {
			gender = 'Male'
		} else if(salutation == 'Mrs.') {
			gender = 'Female'
		} else if(salutation == 'Ms.') {
			gender = 'Female'
		}

		String gender_actual = WebUI.getText(findTestObject('Object Repository/FO/Patient/Patient Data/dropdown_gender'))

		WebUI.verifyMatch(gender_actual, gender, true)

		//WebUI.click(findTestObject('Object Repository/FO/Patient/Patient Data/dropdown_gender'))

		//WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+patient.getValue('Gender', 1)+"' or . = '"+patient.getValue('Gender', 1)+"')]"))

		WebUI.scrollToPosition(100, 300)

		WebUI.click(findTestObject('Object Repository/FO/Patient/Patient Data/dropdown_religion'))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+patient.getValue('Religion', GlobalVariable.patient_data)+"' or . = '"+patient.getValue('Religion', GlobalVariable.patient_data)+"')]"))

		WebUI.click(findTestObject('Object Repository/FO/Patient/Patient Data/dropdown_lastEducation'))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+patient.getValue('Last_education', GlobalVariable.patient_data)+"' or . = '"+patient.getValue('Last_education', GlobalVariable.patient_data)+"')]"))

		WebUI.click(findTestObject('Object Repository/FO/Patient/Patient Data/dropdown_maritalStatus'))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+patient.getValue('Marital_status', GlobalVariable.patient_data)+"' or . = '"+patient.getValue('Marital_status', GlobalVariable.patient_data)+"')]"))

		WebUI.click(findTestObject('Object Repository/FO/Patient/Patient Data/dropdown_occupation'))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+patient.getValue('Occupation', GlobalVariable.patient_data)+"' or . = '"+patient.getValue('Occupation', GlobalVariable.patient_data)+"')]"))

		WebUI.click(findTestObject('Object Repository/FO/Patient/Patient Data/dropdown_nationality'))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+patient.getValue('Nationality', GlobalVariable.patient_data)+"' or . = '"+patient.getValue('Nationality', GlobalVariable.patient_data)+"')]"))

		WebUI.setText(findTestObject('Object Repository/FO/Patient/Patient Data/txt_patient_phone_no'), patient.getValue('no_hp', GlobalVariable.patient_data))

		WebUI.setText(findTestObject('Object Repository/FO/Patient/Patient Data/txt_email'), patient.getValue('email', GlobalVariable.patient_data))
	}

	@And("I click save patient")
	def I_click_save_patient() {
		WebUI.delay(3)

		WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[@type = 'submit' and (text() = 'Save' or . = 'Save')]"), 5)

		WebUI.delay(3)

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[@type = 'submit' and (text() = 'Save' or . = 'Save')]"))
	}
	

	@Then("Data succesfully added")
	def I_verify_the_status_in_step() {
		WebUI.verifyElementPresent(findTestObject('FO/Patient/Patient Data/popup_success'), 20)
		def text = WebUI.getText(findTestObject('FO/Patient/Patient Data/popup_success'))
		WebUI.verifyMatch(text, 'Your form has been saved', true)
		patientno = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div[3]/form/div[4]/div/div/div[3]/div[2]/div/div"))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[@type = 'button' and (text() = 'Back' or . = 'Back')]"))

		WebUI.closeBrowser()
	}

	@Then("Error Mandatory field is show")
	def error_mandatory_field_show() {
		WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[(text() = 'Source Form' or . = 'Source Form')]"), 0)

		WebUI.delay(10)

		WebUI.click(new TestObject().addProperty('id', ConditionType.EQUALS, "3"))

		def mandatory1 = WebUI.getText(findTestObject('FO/Patient/Patient Data/validation_firstname'))
		WebUI.verifyMatch(mandatory1, 'Please insert 1 - 50 characters', true)

		def mandatory2 = WebUI.getText(findTestObject('FO/Patient/Patient Data/validation_phone'))
		WebUI.verifyMatch(mandatory2, 'Please insert 1 - 12 numbers', true)

		WebUI.closeBrowser()
	}
}