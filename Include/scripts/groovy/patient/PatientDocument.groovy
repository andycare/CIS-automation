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



class PatientDocument {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */

	int rows_count

	@When("I click tab document")
	def I_click_tab_document() {
		WebUI.delay(2)

		WebUI.click(findTestObject('Object Repository/FO/Patient/Patient Document/a_Document'))
	}

	@And("I click add document")
	def I_click_add_document() {
		WebUI.click(findTestObject('Object Repository/FO/Patient/Patient Document/button_Add'))
	}

	@And("i input all document field")
	def I_input_all_document_field() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/FO/Patient/Patient Document/toogle_Isdentity'), 10)
		
		WebUI.click(findTestObject('Object Repository/FO/Patient/Patient Document/toogle_Isdentity'))
		
		WebUI.click(findTestObject('Object Repository/FO/Patient/Patient Document/dropdown_docType'))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = 'Patient Document' or . = 'Patient Document')]"))

		WebUI.setText(findTestObject('Object Repository/FO/Patient/Patient Document/textarea_docDescription'), 'Dokumen')

		WebUI.setText(findTestObject('Object Repository/FO/Patient/Patient Document/input_docNo'), '1323241145123454')

		WebUI.click(findTestObject('Object Repository/FO/Patient/Patient Document/div_checkbox_unlimited'))

		WebUI.scrollToElement(findTestObject('Object Repository/FO/Patient/Patient Document/span_Upload File'), 0)

		new uploadFileKey().uploadFile(findTestObject('Object Repository/FO/Patient/Patient Document/span_Upload File'), 'D:\\#01. Data Kerja\\Capture 2.png')

		WebUI.delay(2)
	}

	@And("I select document")
	def I_select_document() {
		WebUI.click(findTestObject('Object Repository/FO/Patient/Patient Document/button_Select'))
	}

	@And("I click save document")
	def I_click_save_document() {
		WebUI.click(findTestObject('Object Repository/FO/Patient/Patient Document/button_Save'))
	}

	@And("I edit document data")
	def I_edit_document() {
		WebUI.clearText(findTestObject('Object Repository/FO/Patient/Patient Document/textarea_docDescription'))

		WebUI.setText(findTestObject('Object Repository/FO/Patient/Patient Document/textarea_docDescription'), 'Dokumen riwayat Medis Patient')

		WebUI.clearText(findTestObject('Object Repository/FO/Patient/Patient Document/input_docNo'))

		WebUI.setText(findTestObject('Object Repository/FO/Patient/Patient Document/input_docNo'), '5678398410876456')
	}

	@And("I Choose document")
	def I_choose_document() {
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

	@And("I click delete")
	def I_click_delete() {
		WebUI.click(findTestObject('Object Repository/FO/Patient/Patient Document/button_Delete'))
	}

	@And("I click yes")
	def I_click_yes() {
		WebUI.delay(2)
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[(text() = 'Yes' or . = 'Yes')]"))
	}

	@Then("document succesfully added")
	def document_succesfully_added() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/FO/Patient/Patient Document/h2_Your document has been saved'), 10)
		def text = WebUI.getText(findTestObject('Object Repository/FO/Patient/Patient Document/h2_Your document has been saved'))
		WebUI.verifyMatch(text, 'Your document has been saved', true)
		WebUI.closeBrowser()
	}

	@Then("Document succesfully updated")
	def document_succesfully_updated() {
		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h2[@id = 'swal2-title' and (text() = 'Your document has been saved' or . = 'Your document has been saved')]"), 10)
		def text = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h2[@id = 'swal2-title' and (text() = 'Your document has been saved' or . = 'Your document has been saved')]"))
		WebUI.verifyMatch(text, 'Your document has been saved', true)
		WebUI.closeBrowser()
	}

	@Then("document succesfully deleted")
	def document_succesfully_deleted() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/FO/Patient/Patient Document/h2_Your document has been deleted'), 10)
		def text = WebUI.getText(findTestObject('Object Repository/FO/Patient/Patient Document/h2_Your document has been deleted'))
		WebUI.verifyMatch(text, 'Your document has been deleted', true)
		WebUI.closeBrowser()
	}
}