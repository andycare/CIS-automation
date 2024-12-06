package mr
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
import customkeyword.uploadFileKey



class RegistrationListNurse {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("I open Registration List Nurse Menu")
	def I_open_nurse_registration_list_menu() {
		WebUI.click(findTestObject('Object Repository/Medical Record/a_serviceActivity'))
		WebUI.click(findTestObject('Object Repository/Medical Record/a_registrationListNurse'))
	}

	@And("I search registration nurse data")
	def I_search_nurse_registration_data() {
		WebUI.focus(findTestObject('Object Repository/Medical Record/Registration List Nurse/textbox_search'))
		WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List Nurse/textbox_search'), GlobalVariable.queuingNo)
		//WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List Nurse/textbox_search'), 'A004')
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List Nurse/button_search'))
	}

	@And("I verify registration nurse data")
	def I_verify_nurse_registration_data() {
		WebUI.scrollToElement(findTestObject('Object Repository/Medical Record/Registration List Nurse/a_registration_info'), 5)
		def RegisNo = WebUI.getAttribute(findTestObject('Object Repository/Medical Record/Registration List Nurse/label_registrationNo'), 'value')
		println(RegisNo)
		def QueuingNo = WebUI.getAttribute(findTestObject('Object Repository/Medical Record/Registration List Nurse/label_queuingNo'), 'value')
		println(QueuingNo)
	}

	@And("I open nurse service activity detail")
	def I_open_nurse_service_activity_detail() {
		WebUI.scrollToElement(findTestObject('Object Repository/Medical Record/Registration List Nurse/span_Service Activity'), 5)
		WebUI.scrollToElement(findTestObject('Object Repository/Medical Record/Registration List Nurse/button_select'), 5)
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List Nurse/button_select'))
	}

	@And("I input nurse service activity information")
	def I_input_nurse_service_activity_information() {
		WebUI.scrollToElement(findTestObject('Object Repository/Medical Record/Registration List Nurse/a_service_activity_information'), 5)
		WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List Nurse/textarea_note'), 'Regular Treatment')
		WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List Nurse/textbox_next_schedule'), '1')
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List Nurse/button_process'))
	}

	@And("I input nurse service activity - Treatment Log Book")
	def I_input_nurse_service_activity_treatment_log() {
		WebUI.scrollToElement(findTestObject('Object Repository/Medical Record/Registration List Nurse/a_service_activity_detail'), 5)
		//WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Treatment Log Book/a_Treatment Log Book'))
		WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List Nurse/Treatment Log Book/textarea_notes'), 'Tes deh')
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List Nurse/Treatment Log Book/button_Save'))
	}

	@And("I input nurse service activity - Item Used")
	def I_input_nurse_service_activity_item_used() {
		WebUI.scrollToElement(findTestObject('Object Repository/Medical Record/Registration List Nurse/a_service_activity_detail'), 5)
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List Nurse/Item Used/a_item_used'))
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List Nurse/Item Used/button_Add'))
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List Nurse/Item Used/dropdown_item'))
		WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List Nurse/Item Used/textbox_item_name'), 'Dermovate Cream 10 g')
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = 'Dermovate Cream 10 g' or . = 'Dermovate Cream 10 g')]"))
		WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List Nurse/Item Used/textbox_quantity'), '1')
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List Nurse/Item Used/button_Save'))
	}

	@And("I input nurse service activity - Foto & Document")
	def I_input_nurse_service_activity_foto_document() {
		WebUI.scrollToElement(findTestObject('Object Repository/Medical Record/Registration List Nurse/a_service_activity_detail'), 5)
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List Nurse/Foto dan Dokumen/a_foto_document'))
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List Nurse/Foto dan Dokumen/dropdown_photo_type'))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = 'Medical Record Photo' or . = 'Medical Record Photo')]"))
		WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List Nurse/Foto dan Dokumen/textarea_document_desc'), 'Dokumen Medis')
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List Nurse/Foto dan Dokumen/button_choose'))
		WebUI.delay(2)
		new uploadFileKey().uploadFile(findTestObject('Object Repository/Medical Record/Registration List Nurse/Foto dan Dokumen/button_upload_doc'), 'D:\\#01. Data Kerja\\Capture 2.jpg')
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List Nurse/Foto dan Dokumen/button_upload_all'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List Nurse/Foto dan Dokumen/button_close'))
	}

	@When("I open registration list nurse detail")
	def I_open_nurse_registration__list_detail() {
		WebUI.scrollToElement(findTestObject('Object Repository/Medical Record/Registration List Nurse/button_refresh'), 5)
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List Nurse/button_select'))
	}

	@Then("Service activity nurse success inputed")
	def nurse_service_activity_inputed() {
		WebUI.scrollToPosition(0, 0)
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List Nurse/button_Back'))
		WebUI.scrollToPosition(0, 0)
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List Nurse/button_Back'))
	}

	@Then("Success input nurse service activity detail")
	def success_input_nurse_service_activity_detail() {
		WebUI.scrollToPosition(0, 0)
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/button_Back'))
		WebUI.scrollToPosition(0, 0)
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/button_Back'))
	}
}