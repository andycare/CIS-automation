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



class PatientGuarantor {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */

	def patient = findTestData("Patient/Patient_data")
	def patient_guarantor = findTestData("Patient/Patient_guarantor")
	int rows_count
	int seq = GlobalVariable.Patient_guarantor + 1

	@When("I click tab guarantor")
	def I_click_tab_guarantor() {
		WebUI.delay(2)

		WebUI.click(findTestObject('Object Repository/FO/Patient/Patient Guarantor/a_Guarantor'))
	}


	@And("I click add guarantor")
	def I_click_add_guarantor() {
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//button[(text() = \'Add\' or . = \'Add\')]'))
	}

	@And("i input all guarantor field")
	def I_input_all_guarantor_field() {
		WebUI.setText(findTestObject('Object Repository/FO/Patient/Patient Guarantor/input_guarantorName'), patient_guarantor.getValue('guarantor_name', GlobalVariable.Patient_guarantor))

		WebUI.click(findTestObject('Object Repository/FO/Patient/Patient Guarantor/dropdown_guarantor_type'))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+patient_guarantor.getValue('relation_type', GlobalVariable.Patient_guarantor)+"' or . = '"+patient_guarantor.getValue('relation_type', GlobalVariable.Patient_guarantor)+"')]"))

		new DatepickerPatient().pickDate(findTestObject('Object Repository/FO/Patient/Patient Guarantor/button_datepicker'), patient_guarantor.getValue('birthdate', GlobalVariable.Patient_guarantor))

		WebUI.setText(findTestObject('Object Repository/FO/Patient/Patient Guarantor/input_guarantorIdNo'), patient_guarantor.getValue('id_no', GlobalVariable.Patient_guarantor))

		WebUI.setText(findTestObject('Object Repository/FO/Patient/Patient Guarantor/input_phoneNo'), patient_guarantor.getValue('phone_no', GlobalVariable.Patient_guarantor))

		WebUI.setText(findTestObject('Object Repository/FO/Patient/Patient Guarantor/input_guarantorAddress'), patient_guarantor.getValue('address', GlobalVariable.Patient_guarantor))

		WebUI.scrollToElement(findTestObject('Object Repository/FO/Patient/Patient Guarantor/dropdown_province'), 0)

		WebUI.click(findTestObject('Object Repository/FO/Patient/Patient Guarantor/dropdown_province'))

		WebUI.enhancedClick(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+patient_guarantor.getValue('province', GlobalVariable.Patient_guarantor)+"' or . = '"+patient_guarantor.getValue('province', GlobalVariable.Patient_guarantor)+"')]"))

		WebUI.click(findTestObject('Object Repository/FO/Patient/Patient Guarantor/button_search'))

		WebUI.setText(findTestObject('Object Repository/FO/Patient/Patient Guarantor/txt_searchDistrict'), patient_guarantor.getValue('district', GlobalVariable.Patient_guarantor))

		WebUI.enhancedClick(findTestObject('Object Repository/FO/Patient/Patient Guarantor/button_search'))

		WebUI.enhancedClick(findTestObject('Object Repository/FO/Patient/Patient Guarantor/button_Select_zipcode'))

		WebUI.setText(findTestObject('Object Repository/FO/Patient/Patient Guarantor/input_guarantorRt'), patient_guarantor.getValue('rt', GlobalVariable.Patient_guarantor))

		WebUI.setText(findTestObject('Object Repository/FO/Patient/Patient Guarantor/input_guarantorRw'), patient_guarantor.getValue('rw', GlobalVariable.Patient_guarantor))
	}

	@And("I edit guarantor data")
	def I_edit_guarantor() {
		WebUI.click(findTestObject('Object Repository/FO/Patient/Patient Guarantor/dropdown_RelationType'))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+patient_guarantor.getValue('relation_type', seq)+"' or . = '"+patient_guarantor.getValue('relation_type', seq)+"')]"))

		WebUI.clearText(findTestObject('Object Repository/FO/Patient/Patient Guarantor/input_guarantorIdNo'))

		WebUI.setText(findTestObject('Object Repository/FO/Patient/Patient Guarantor/input_guarantorIdNo'), patient_guarantor.getValue('id_no', seq))

		WebUI.clearText(findTestObject('Object Repository/FO/Patient/Patient Guarantor/input_guarantorAddress'))

		WebUI.setText(findTestObject('Object Repository/FO/Patient/Patient Guarantor/input_guarantorAddress'), patient_guarantor.getValue('address', seq))
	}

	@And("I select guarantor")
	def I_select_guarantor() {
		WebUI.click(findTestObject('Object Repository/FO/Patient/Patient Guarantor/button_Select'))
	}

	@And("I click save guarantor")
	def I_click_save_guarantor() {
		WebUI.click(findTestObject('Object Repository/FO/Patient/Patient Guarantor/button_Save'))
	}

	@Then("guarantor succesfully added")
	def guarantor_succesfully_added() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/FO/Patient/Patient Guarantor/h2_Your Guarantor has been saved'), 10)
		def text = WebUI.getText(findTestObject('Object Repository/FO/Patient/Patient Guarantor/h2_Your Guarantor has been saved'))
		WebUI.verifyMatch(text, 'Your Guarantor has been saved', true)
		WebUI.closeBrowser()
	}

	@And("I Choose guarantor")
	def I_choose_guarantor() {
		WebUI.delay(5)

		WebDriver driver = DriverFactory.getWebDriver()
		//'To locate table'
		WebElement Table = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[2]/div[4]/div/div/div[2]/div/div[2]/div/div/table/tbody"))
		//'To locate rows of table it will Capture all the rows available in the table'
		List<WebElement> rows_table = Table.findElements(By.tagName('tr'))
		//'To calculate no of rows In table'

		rows_count = rows_table.size()

		for (int row = 0; row < rows_count; row++) {
			//'To locate columns(cells) of that specific row'
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName('td'))

			//'To calculate no of columns(cells) In that specific row'
			int columns_count = Columns_row.size()
			Columns_row.get(0).click()
		}
	}


	@Then("guarantor succesfully deleted")
	def guarantor_succesfully_deleted() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/FO/Patient/Patient Guarantor/h2_Your guarantor has been deleted'), 10)
		def text = WebUI.getText(findTestObject('Object Repository/FO/Patient/Patient Guarantor/h2_Your guarantor has been deleted'))
		WebUI.verifyMatch(text, 'Your guarantor has been deleted', true)
		WebUI.closeBrowser()
	}

	@Then("Guarantor succesfully updated")
	def guarantor_succesfully_updated() {
		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h2[@id = 'swal2-title' and (text() = 'Your guarantor has been edit' or . = 'Your guarantor has been edit')]"), 10)
		def text = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h2[@id = 'swal2-title' and (text() = 'Yourguarantor has been edit' or . = 'Your guarantor has been edit')]"))
		WebUI.verifyMatch(text, 'Your guarantor has been edit', true)
		WebUI.closeBrowser()
	}
}