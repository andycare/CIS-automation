package fo
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
import com.kms.katalon.core.webui.common.WebUiCommonHelper

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

import customkeyword.Datepicker
import org.openqa.selenium.Keys



class Appointment {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	def patient = findTestData("Patient/Patient_data")

	@Given("I open appointment page")
	def I_open_appointment_page() {
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//a[@href = '#/dashboard' and (text() = 'Frontline' or . = 'Frontline')]"))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//a[@href = '#/appointment' and (text() = 'Appointment' or . = 'Appointment')]"))
	}

	@When("I click add appointment")
	def I_click_add_appointment() {
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[(text() = 'Add' or . = 'Add')]"))
	}

	@And("I open appointment detail")
	def I_open_appointment_detail() {
		def patientname = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div[2]/div/div/div[4]"))
		def phoneno = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div[2]/div[2]/div/div[2]"))
		def email = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div[2]/div[2]/div/div[4]"))
		def fullname = WebUI.concatenate([patient.getValue('Patient_First_Name', 1), ' ', patient.getValue('Patient_Middle_Name', 1), ' ', patient.getValue('Patient_Last_Name', 1)] as String[])
		WebUI.verifyMatch(patientname, fullname, true)
		WebUI.verifyMatch(phoneno, patient.getValue('no_hp', 1), true)
		WebUI.verifyMatch(email, patient.getValue('email', 1), true)
	}

	@And("I input appointment info")
	def I_input_appointment_info() {
		WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[(text() = 'Select a TreatmentSelect a Treatment' or . = 'Select a TreatmentSelect a Treatment')]"), 5)

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//span[(text() = 'Select a Service Activity' or . = 'Select a Service Activity')]"))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = 'Reguler Treatment' or . = 'Reguler Treatment')]"))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//span[(text() = 'Select a Treatment' or . = 'Select a Treatment')]"))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = 'Double Basic DPCT (Medical Grade Facial)' or . = 'Double Basic DPCT (Medical Grade Facial)')]"))

		new Datepicker().pickDate(new TestObject().addProperty('xpath', ConditionType.EQUALS, "(//input[@type='text'])[6]"), '11/28/2023')

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/form/div/div[2]/div[2]/div/div/div[2]/div/div/div/span"))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = 'Ruang Reguler Treatment 1 - Bed 1 : 10:00:00 - 10:30:00' or . = 'Ruang Reguler Treatment 1 - Bed 1 : 10:00:00 - 10:30:00')]"))

		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//textarea[@type='text']"), 'Janji Baru')
	}

	@And("I verify appointment info data")
	def I_verify_appointment_info_data() {
		WebUI.scrollToElement(findTestObject('Object Repository/FO/Appointment/label_AppointmentInfo'), 5)

		def branch = WebUI.getText(findTestObject('Object Repository/FO/Appointment/label_branch'))
		def service_activity = WebUI.getText(findTestObject('Object Repository/FO/Appointment/Label_serviceActivity'))
		def doctor = WebUI.getText(findTestObject('Object Repository/FO/Appointment/label_doctor'))
		def treatment = WebUI.getText(findTestObject('Object Repository/FO/Appointment/label_treatment'))
		def tanggal = WebUI.getText(findTestObject('Object Repository/FO/Appointment/label_date'))
		def waktu = WebUI.getText(findTestObject('Object Repository/FO/Appointment/label_time'))

		Date date = new Date('11/28/2023')
		def formatedDate = date.format('dd MMM yyyy')
		String str = 'Ruang Reguler Treatment 1 - Bed 1 : 10:00:00 - 10:30:00'

		WebUI.verifyMatch(branch, 'Klinik Utama Erha Ultimate BSD', true)
		WebUI.verifyMatch(service_activity, 'Reguler Treatment', true)
		WebUI.verifyMatch(doctor, '-', true)
		WebUI.verifyMatch(treatment, 'Double Basic DPCT \\(Medical Grade Facial\\)', true)
		WebUI.verifyMatch(tanggal, formatedDate, true)
		WebUI.verifyMatch(waktu, str.substring(36, 44), true)

		WebUI.scrollToElement(findTestObject('Object Repository/FO/Appointment/btn_post'), 5)
	}

	@And("I click post appointment")
	def I_click_post() {
		WebUI.click(findTestObject('Object Repository/FO/Appointment/btn_post'))
	}

	@Then("appointment create")
	def appointment_created() {
	}
}