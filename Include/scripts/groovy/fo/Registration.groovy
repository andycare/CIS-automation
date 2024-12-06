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

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class Registration {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */

	def registrationNo
	def queuingNo
	def patient = findTestData("Patient/Patient_data")
	def registration = findTestData("Registration/registration_data")

	@Given("I open registration page")
	def I_open_registration_page() {
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//a[@href = '#/dashboard' and (text() = 'Frontline' or . = 'Frontline')]"))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//a[@href = '#/registration' and (text() = 'Registration' or . = 'Registration')]"))
	}

	@When("I click add registration")
	def I_click_add_registration() {
		WebUI.click(findTestObject('Object Repository/FO/Registration/btn_add'))
	}

	@And("I open registration detail")
	def I_open_registration_patient() {
		def patientname = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/form/div[2]/div/div/div[4]"))
		def phoneno = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/form/div[2]/div[2]/div/div[2]"))
		def email = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/form/div[2]/div[2]/div/div[4]"))
		def fullname = WebUI.concatenate([patient.getValue('Patient_First_Name', GlobalVariable.registrasi), ' ', patient.getValue('Patient_Middle_Name', GlobalVariable.registrasi), ' ', patient.getValue('Patient_Last_Name', GlobalVariable.registrasi)] as String[])
		WebUI.verifyMatch(patientname, fullname, true)
		WebUI.verifyMatch(phoneno, patient.getValue('no_hp', GlobalVariable.registrasi), true)
		WebUI.verifyMatch(email, patient.getValue('email', GlobalVariable.registrasi), true)
	}

	@And("I open registration detail - pharmacy")
	def I_open_registration_patient_pharmacy() {
		def patientname = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/form/div[2]/div/div/div[4]"))
		def phoneno = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/form/div[2]/div[2]/div/div[2]"))
		def email = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/form/div[2]/div[2]/div/div[4]"))
		def fullname = WebUI.concatenate([patient.getValue('Patient_First_Name', GlobalVariable.registrasi), ' ', patient.getValue('Patient_Middle_Name', GlobalVariable.registrasi), ' ', patient.getValue('Patient_Last_Name', GlobalVariable.registrasi)] as String[])
		WebUI.verifyMatch(patientname, fullname, true)
		WebUI.verifyMatch(phoneno, patient.getValue('no_hp', GlobalVariable.registrasi), true)
		WebUI.verifyMatch(email, patient.getValue('email', GlobalVariable.registrasi), true)
	}

	@And("I input registration info Consul")
	def I_input_registration_info_Consul() {
		WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/label_RegistrationInfo'), 5)

		WebUI.setText(findTestObject('Object Repository/FO/Registration/textarea_note'), registration.getValue('note', 1))

		WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/dropdown_reservation_type'), 5)

		WebUI.click(findTestObject('Object Repository/FO/Registration/dropdown_reservation_type'))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+registration.getValue('Reservation_Type', 1)+"' or . = '"+registration.getValue('Reservation_Type', 1)+"')]"))

		WebUI.scrollToElement(findTestObject('Object Repository/Page_CIS Train/button_next'), 5)
	}

	@And("I input registration info RT")
	def I_input_registration_info_RT() {
		WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/label_RegistrationInfo'), 5)

		WebUI.setText(findTestObject('Object Repository/FO/Registration/textarea_note'), registration.getValue('note', 2))

		WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/dropdown_reservation_type'), 5)

		WebUI.click(findTestObject('Object Repository/FO/Registration/dropdown_reservation_type'))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+registration.getValue('Reservation_Type', 2)+"' or . = '"+registration.getValue('Reservation_Type', 2)+"')]"))

		WebUI.scrollToElement(findTestObject('Object Repository/Page_CIS Train/button_next'), 5)
	}

	@And("I input registration info Treatment")
	def I_input_registration_info_Treatment() {
		WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/label_RegistrationInfo'), 5)

		WebUI.setText(findTestObject('Object Repository/FO/Registration/textarea_note'), registration.getValue('note', 3))

		WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/dropdown_reservation_type'), 5)

		WebUI.click(findTestObject('Object Repository/FO/Registration/dropdown_reservation_type'))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+registration.getValue('Reservation_Type', 3)+"' or . = '"+registration.getValue('Reservation_Type', 3)+"')]"))

		WebUI.scrollToElement(findTestObject('Object Repository/Page_CIS Train/button_next'), 5)
	}

	@And("I input registration info4")
	def I_input_registration_info4() {
		WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/label_RegistrationInfo'), 5)

		WebUI.setText(findTestObject('Object Repository/FO/Registration/textarea_note'), 'New Patient Registration (More than 1 service activity)')

		WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/dropdown_reservation_type'), 5)

		WebUI.click(findTestObject('Object Repository/FO/Registration/dropdown_reservation_type'))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+registration.getValue('Reservation_Type', 1)+"' or . = '"+registration.getValue('Reservation_Type', 1)+"')]"))

		WebUI.scrollToElement(findTestObject('Object Repository/Page_CIS Train/button_next'), 5)
	}

	@And("I input registration info5")
	def I_input_registration_info5() {
		WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/label_RegistrationInfo'), 5)

		WebUI.setText(findTestObject('Object Repository/FO/Registration/textarea_note'), registration.getValue('note', 4))

		WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/dropdown_reservation_type'), 5)

		WebUI.click(findTestObject('Object Repository/FO/Registration/dropdown_reservation_type'))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+registration.getValue('Reservation_Type', 1)+"' or . = '"+registration.getValue('Reservation_Type', 1)+"')]"))

		WebUI.scrollToElement(findTestObject('Object Repository/Page_CIS Train/button_next'), 5)
	}

	@And("I input registration info detail Consul")
	def I_input_registration_info_detail_Consul() {
		WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/label_RegistrationInfo'), 5)

		WebUI.click(findTestObject('Object Repository/FO/Registration/btn_add'))

		WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/btn_add'), 5)

		WebUI.click(findTestObject('Object Repository/FO/Registration/dropdown_service_activity'))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+registration.getValue('Service_activity', 1)+"' or . = '"+registration.getValue('Service_activity', 1)+"')]"))

		WebUI.click(findTestObject('Object Repository/FO/Registration/dropdown_doctor'))

		//WebUI.focus(findTestObject('Object Repository/FO/Registration/textbox_doctor'))

		WebUI.setText(findTestObject('Object Repository/FO/Registration/textbox_doctor'), registration.getValue('Doctor', 1))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+registration.getValue('Doctor', 1)+"' or . = '"+registration.getValue('Doctor', 1)+"')]"))

		WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/dropdown_product_service'), 5)

		WebUI.click(findTestObject('Object Repository/FO/Registration/dropdown_product_service'))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+registration.getValue('Product_service', 1)+"' or . = '"+registration.getValue('Product_service', 1)+"')]"))

		WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/dropdown_room_schedule'), 5)

		WebUI.click(findTestObject('Object Repository/FO/Registration/dropdown_room_schedule'))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+registration.getValue('Room_schedule', 1)+"' or . = '"+registration.getValue('Room_schedule', 1)+"')]"))

		WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/btn_save'), 5)

		WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/btn_add'), 5)
	}

	@And("I input registration info detail RT")
	def I_input_registration_info_detail_RT() {
		WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/label_RegistrationInfo'), 5)

		WebUI.click(findTestObject('Object Repository/FO/Registration/btn_add'))

		WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/btn_add'), 5)

		WebUI.click(findTestObject('Object Repository/FO/Registration/dropdown_service_activity'))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+registration.getValue('Service_activity', 2)+"' or . = '"+registration.getValue('Service_activity', 2)+"')]"))

		WebUI.click(findTestObject('Object Repository/FO/Registration/dropdown_product_service'))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+registration.getValue('Product_service', 2)+"' or . = '"+registration.getValue('Product_service', 2)+"')]"))

		WebUI.click(findTestObject('Object Repository/FO/Registration/dropdown_room_schedule'))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+registration.getValue('Room_schedule', 2)+"' or . = '"+registration.getValue('Room_schedule', 2)+"')]"))

		WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/btn_save'), 5)

		WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/btn_add'), 5)
	}

	@And("I search patient data pharmacy")
	def I_search_patient_data_pharmacy() {
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='dropdown']/span"))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = 'Patient Phone' or . = 'Patient Phone')]"))

		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@placeholder = 'Patient Name / Birthdate / Phone No.']"), patient.getValue('no_hp', GlobalVariable.registrasi))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[(text() = ' ' or . = ' ')]"))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[(text() = 'Select' or . = 'Select')]"))
	}

	@And("I input registration info detail Treatment")
	def I_input_registration_info_detail_Treatment() {
		WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/label_RegistrationInfo'), 5)

		WebUI.click(findTestObject('Object Repository/FO/Registration/btn_add'))

		WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/btn_add'), 5)

		WebUI.click(findTestObject('Object Repository/FO/Registration/dropdown_service_activity'))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+registration.getValue('Service_activity', 3)+"' or . = '"+registration.getValue('Service_activity', 3)+"')]"))

		WebUI.click(findTestObject('Object Repository/FO/Registration/dropdown_doctor'))

		WebUI.focus(findTestObject('Object Repository/FO/Registration/textbox_doctor'))

		WebUI.setText(findTestObject('Object Repository/FO/Registration/textbox_doctor'), registration.getValue('Doctor', 3))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+registration.getValue('Doctor', 3)+"' or . = '"+registration.getValue('Doctor', 3)+"')]"))

		WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/btn_add'), 5)

		WebUI.click(findTestObject('Object Repository/FO/Registration/dropdown_product_service'))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+registration.getValue('Product_service', 3)+"' or . = '"+registration.getValue('Product_service', 3)+"')]"))

		WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/btn_add'), 5)

		WebUI.click(findTestObject('Object Repository/FO/Registration/dropdown_room_schedule'))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+registration.getValue('Room_schedule', 3)+"' or . = '"+registration.getValue('Room_schedule', 3)+"')]"))

		WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/btn_save'), 5)

		WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/btn_add'), 5)
	}

	@And("I input registration info detail-Pharmacy")
	def I_input_registration_info_detail4() {
		WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/label_RegistrationInfo'), 5)

		WebUI.click(findTestObject('Object Repository/FO/Registration/btn_add'))

		WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/btn_add'), 5)

		WebUI.click(findTestObject('Object Repository/FO/Registration/dropdown_service_activity'))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+registration.getValue('Service_activity', 4)+"' or . = '"+registration.getValue('Service_activity', 4)+"')]"))

		WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/btn_save'), 5)

		WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/btn_add'), 5)
	}

	@And("I verify registration info data created")
	def I_verify_registration_info_data_created() {
		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h2[@id = 'swal2-title' and (text() = 'Your record has been saved' or . = 'Your record has been saved')]"), 10)
		def text = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h2[@id = 'swal2-title' and (text() = 'Your record has been saved' or . = 'Your record has been saved')]"))
		WebUI.verifyMatch(text, 'Your record has been saved', true)

		WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[(text() = 'Next' or . = 'Next')]"), 5)
	}

	@And("I verify registration info data Consul")
	def I_verify_registration_info_data_Consul() {
		registrationNo = WebUI.getText(findTestObject('Object Repository/FO/Appointment/label_registrationNo'))
		GlobalVariable.registrationNo = WebUI.getText(findTestObject('Object Repository/FO/Appointment/label_registrationNo'))
		println(registrationNo)

		WebDriver driver = DriverFactory.getWebDriver()
		//'To locate table'
		WebElement Table = driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div[2]/div[2]/div[3]/div[1]/div[3]/div/div/table/tbody"))
		//'To locate rows of table it will Capture all the rows available in the table'
		List<WebElement> rows_table = Table.findElements(By.tagName('tr'))
		//'To calculate no of rows In table'
		int rows_count = rows_table.size()

		for (int row = 0; row < rows_count; row++) {
			//'To locate columns(cells) of that specific row'
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName('td'))

			//'To calculate no of columns(cells) In that specific row'
			int columns_count = Columns_row.size()

			//'Loop will execute till the last cell of that specific row'
			for (int column = 0; column < columns_count; column++) {
				String celltext = Columns_row.get(column).getText()
				println(celltext)

				if(column == 1) {
					WebUI.verifyMatch(celltext, registration.getValue('Service_activity', 1), true)
				}
				if(column == 2) {
					WebUI.verifyMatch(celltext, registration.getValue('Doctor', 1), true)
				}
				if(column == 3) {
					WebUI.verifyMatch(celltext, 'Acne Scar Solution \\- Acne Finale Acne Scar Program', true)
				}
			}
		}

		WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/label_registrationFeeInfo'), 5)

	}

	@And("I verify registration info data RT")
	def I_verify_registration_info_data_RT() {
		registrationNo = WebUI.getText(findTestObject('Object Repository/FO/Appointment/label_registrationNo'))
		GlobalVariable.registrationNo = WebUI.getText(findTestObject('Object Repository/FO/Appointment/label_registrationNo'))
		println(registrationNo)

		WebDriver driver = DriverFactory.getWebDriver()
		//'To locate table'
		WebElement Table = driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div[2]/div[2]/div[3]/div[1]/div[3]/div/div/table/tbody"))
		//'To locate rows of table it will Capture all the rows available in the table'
		List<WebElement> rows_table = Table.findElements(By.tagName('tr'))
		//'To calculate no of rows In table'
		int rows_count = rows_table.size()

		for (int row = 0; row < rows_count; row++) {
			//'To locate columns(cells) of that specific row'
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName('td'))

			//'To calculate no of columns(cells) In that specific row'
			int columns_count = Columns_row.size()

			//'Loop will execute till the last cell of that specific row'
			for (int column = 0; column < columns_count; column++) {
				String celltext = Columns_row.get(column).getText()
				println(celltext)

				if(column == 1) {
					WebUI.verifyMatch(celltext, registration.getValue('Service_activity', 2), true)
				}
				if(column == 2) {
					WebUI.verifyMatch(celltext, registration.getValue('Doctor', 2), true)
				}
				if(column == 3) {
					WebUI.verifyMatch(celltext, registration.getValue('Product_service', 2), true)
				}
			}
		}

		WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/label_registrationFeeInfo'), 5)

	}

	@And("I verify registration info data Treatment")
	def I_verify_registration_info_data_Treatment() {
		registrationNo = WebUI.getText(findTestObject('Object Repository/FO/Appointment/label_registrationNo'))
		GlobalVariable.registrationNo = WebUI.getText(findTestObject('Object Repository/FO/Appointment/label_registrationNo'))
		println(registrationNo)

		WebDriver driver = DriverFactory.getWebDriver()
		//'To locate table'
		WebElement Table = driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div[2]/div[2]/div[3]/div[1]/div[3]/div/div/table/tbody"))
		//'To locate rows of table it will Capture all the rows available in the table'
		List<WebElement> rows_table = Table.findElements(By.tagName('tr'))
		//'To calculate no of rows In table'
		int rows_count = rows_table.size()

		for (int row = 0; row < rows_count; row++) {
			//'To locate columns(cells) of that specific row'
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName('td'))

			//'To calculate no of columns(cells) In that specific row'
			int columns_count = Columns_row.size()

			//'Loop will execute till the last cell of that specific row'
			for (int column = 0; column < columns_count; column++) {
				String celltext = Columns_row.get(column).getText()
				println(celltext)

				if(column == 1) {
					WebUI.verifyMatch(celltext, registration.getValue('Service_activity', 3), true)
				}
				if(column == 2) {
					WebUI.verifyMatch(celltext, registration.getValue('Doctor', 3), true)
				}
				if(column == 3) {
					WebUI.verifyMatch(celltext, registration.getValue('Product_service', 3), true)
				}
			}
		}

		WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/label_registrationFeeInfo'), 5)

	}

	@And("I verify registration info data4")
	def I_verify_registration_info_data4() {
		registrationNo = WebUI.getText(findTestObject('Object Repository/FO/Appointment/label_registrationNo'))
		GlobalVariable.registrationNo = WebUI.getText(findTestObject('Object Repository/FO/Appointment/label_registrationNo'))
		println(registrationNo)

		WebDriver driver = DriverFactory.getWebDriver()
		//'To locate table'
		WebElement Table = driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div[2]/div[2]/div[3]/div[1]/div[3]/div/div/table/tbody"))
		//'To locate rows of table it will Capture all the rows available in the table'
		List<WebElement> rows_table = Table.findElements(By.tagName('tr'))
		//'To calculate no of rows In table'
		int rows_count = rows_table.size()

		for (int row = 0; row < rows_count; row++) {
			//'To locate columns(cells) of that specific row'
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName('td'))

			//'To calculate no of columns(cells) In that specific row'
			int columns_count = Columns_row.size()

			//'Loop will execute till the last cell of that specific row'
			for (int column = 0; column < columns_count; column++) {
				String celltext = Columns_row.get(column).getText()
				println(celltext)

				if(row == 0) {
					if(column == 1) {
						WebUI.verifyMatch(celltext, registration.getValue('Service_activity', 3), true)
					}
					if(column == 2) {
						WebUI.verifyMatch(celltext, registration.getValue('Doctor', 3), true)
					}
					if(column == 3) {
						WebUI.verifyMatch(celltext, registration.getValue('Product_service', 3), true)
					}
				}
				if(row == 1) {
					if(column == 1) {
						WebUI.verifyMatch(celltext, registration.getValue('Service_activity', 2), true)
					}
					if(column == 2) {
						WebUI.verifyMatch(celltext, registration.getValue('Doctor', 2), true)
					}
					if(column == 3) {
						WebUI.verifyMatch(celltext, registration.getValue('Product_service', 2), true)
					}
				}
			}
		}

		WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/label_registrationFeeInfo'), 5)

	}

	@And("I verify registration info data5")
	def I_verify_registration_info_data5() {
		registrationNo = WebUI.getText(findTestObject('Object Repository/FO/Appointment/label_registrationNo'))
		GlobalVariable.registrationNo = WebUI.getText(findTestObject('Object Repository/FO/Appointment/label_registrationNo'))
		println(registrationNo)

		WebDriver driver = DriverFactory.getWebDriver()
		//'To locate table'
		WebElement Table = driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div[2]/div[2]/div[3]/div[1]/div[3]/div/div/table/tbody"))
		//'To locate rows of table it will Capture all the rows available in the table'
		List<WebElement> rows_table = Table.findElements(By.tagName('tr'))
		//'To calculate no of rows In table'
		int rows_count = rows_table.size()

		for (int row = 0; row < rows_count; row++) {
			//'To locate columns(cells) of that specific row'
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName('td'))

			//'To calculate no of columns(cells) In that specific row'
			int columns_count = Columns_row.size()

			//'Loop will execute till the last cell of that specific row'
			for (int column = 0; column < columns_count; column++) {
				String celltext = Columns_row.get(column).getText()
				println(celltext)

				if(row == 0) {
					if(column == 1) {
						WebUI.verifyMatch(celltext, registration.getValue('Service_activity', 1), true)
					}
					if(column == 2) {
						WebUI.verifyMatch(celltext, registration.getValue('Doctor', 1), true)
					}
					if(column == 3) {
						WebUI.verifyMatch(celltext, 'Acne Scar Solution \\- Acne Finale Acne Scar Program', true)
					}
				}
				if(row == 1) {
					if(column == 1) {
						WebUI.verifyMatch(celltext, registration.getValue('Service_activity', 3), true)
					}
					if(column == 2) {
						WebUI.verifyMatch(celltext, registration.getValue('Doctor', 3), true)
					}
					if(column == 3) {
						WebUI.verifyMatch(celltext, registration.getValue('Product_service', 3), true)
					}
				}
			}
		}

		WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/label_registrationFeeInfo'), 5)

	}

	@And("I verify registration info data6")
	def I_verify_registration_info_data6() {
		registrationNo = WebUI.getText(findTestObject('Object Repository/FO/Appointment/label_registrationNo'))
		GlobalVariable.registrationNo = WebUI.getText(findTestObject('Object Repository/FO/Appointment/label_registrationNo'))
		println(registrationNo)

		WebDriver driver = DriverFactory.getWebDriver()
		//'To locate table'
		WebElement Table = driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div[2]/div[2]/div[3]/div[1]/div[3]/div/div/table/tbody"))
		//'To locate rows of table it will Capture all the rows available in the table'
		List<WebElement> rows_table = Table.findElements(By.tagName('tr'))
		//'To calculate no of rows In table'
		int rows_count = rows_table.size()

		for (int row = 0; row < rows_count; row++) {
			//'To locate columns(cells) of that specific row'
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName('td'))

			//'To calculate no of columns(cells) In that specific row'
			int columns_count = Columns_row.size()

			//'Loop will execute till the last cell of that specific row'
			for (int column = 0; column < columns_count; column++) {
				String celltext = Columns_row.get(column).getText()
				println(celltext)

				if(row == 0) {
					if(column == 1) {
						WebUI.verifyMatch(celltext, registration.getValue('Service_activity', 1), true)
					}
					if(column == 2) {
						WebUI.verifyMatch(celltext, registration.getValue('Doctor', 1), true)
					}
					if(column == 3) {
						WebUI.verifyMatch(celltext, 'Acne Scar Solution \\- Acne Finale Acne Scar Program', true)
					}
				}
				if(row == 1) {
					if(column == 1) {
						WebUI.verifyMatch(celltext, registration.getValue('Service_activity', 2), true)
					}
					if(column == 2) {
						WebUI.verifyMatch(celltext, registration.getValue('Doctor', 2), true)
					}
					if(column == 3) {
						WebUI.verifyMatch(celltext, registration.getValue('Product_service', 2), true)
					}
				}
			}
		}

		WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/label_registrationFeeInfo'), 5)

	}

	@And("I verify registration info data7")
	def I_verify_registration_info_data7() {
		registrationNo = WebUI.getText(findTestObject('Object Repository/FO/Appointment/label_registrationNo'))
		GlobalVariable.registrationNo = WebUI.getText(findTestObject('Object Repository/FO/Appointment/label_registrationNo'))
		println(registrationNo)

		WebDriver driver = DriverFactory.getWebDriver()
		//'To locate table'
		WebElement Table = driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div[2]/div[2]/div[3]/div[1]/div[3]/div/div/table/tbody"))
		//'To locate rows of table it will Capture all the rows available in the table'
		List<WebElement> rows_table = Table.findElements(By.tagName('tr'))
		//'To calculate no of rows In table'
		int rows_count = rows_table.size()

		for (int row = 0; row < rows_count; row++) {
			//'To locate columns(cells) of that specific row'
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName('td'))

			//'To calculate no of columns(cells) In that specific row'
			int columns_count = Columns_row.size()

			//'Loop will execute till the last cell of that specific row'
			for (int column = 0; column < columns_count; column++) {
				String celltext = Columns_row.get(column).getText()
				println(celltext)

				if(row == 0) {
					if(column == 1) {
						WebUI.verifyMatch(celltext, registration.getValue('Service_activity', 1), true)
					}
					if(column == 2) {
						WebUI.verifyMatch(celltext, registration.getValue('Doctor', 1), true)
					}
					if(column == 3) {
						WebUI.verifyMatch(celltext, 'Acne Scar Solution \\- Acne Finale Acne Scar Program', true)
					}
				}
				if(row == 1) {
					if(column == 1) {
						WebUI.verifyMatch(celltext, registration.getValue('Service_activity', 2), true)
					}
					if(column == 2) {
						WebUI.verifyMatch(celltext, registration.getValue('Doctor', 2), true)
					}
					if(column == 3) {
						WebUI.verifyMatch(celltext, registration.getValue('Product_service', 2), true)
					}
				}
				if(row == 2) {
					if(column == 1) {
						WebUI.verifyMatch(celltext, registration.getValue('Service_activity', 3), true)
					}
					if(column == 2) {
						WebUI.verifyMatch(celltext, registration.getValue('Doctor', 3), true)
					}
					if(column == 3) {
						WebUI.verifyMatch(celltext, registration.getValue('Product_service', 3), true)
					}
				}
			}
		}

		WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/label_registrationFeeInfo'), 5)

	}

	@And("I verify registration info data8")
	def I_verify_registration_info_data8() {
		registrationNo = WebUI.getText(findTestObject('Object Repository/FO/Appointment/label_registrationNo'))
		GlobalVariable.registrationNo = WebUI.getText(findTestObject('Object Repository/FO/Appointment/label_registrationNo'))

		println(registrationNo)

		WebDriver driver = DriverFactory.getWebDriver()
		//'To locate table'
		WebElement Table = driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div[2]/div[2]/div[3]/div[1]/div[3]/div/div/table/tbody"))
		//'To locate rows of table it will Capture all the rows available in the table'
		List<WebElement> rows_table = Table.findElements(By.tagName('tr'))
		//'To calculate no of rows In table'
		int rows_count = rows_table.size()

		for (int row = 0; row < rows_count; row++) {
			//'To locate columns(cells) of that specific row'
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName('td'))

			//'To calculate no of columns(cells) In that specific row'
			int columns_count = Columns_row.size()

			//'Loop will execute till the last cell of that specific row'
			for (int column = 0; column < columns_count; column++) {
				String celltext = Columns_row.get(column).getText()
				println(celltext)

				if(column == 1) {
					WebUI.verifyMatch(celltext, registration.getValue('Service_activity', 4), true)
				}
				if(column == 2) {
					WebUI.verifyMatch(celltext, registration.getValue('Doctor', 4), true)
				}
				if(column == 3) {
					WebUI.verifyMatch(celltext, registration.getValue('Product_service', 4), true)
				}
			}
		}

		WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/label_registrationFeeInfo'), 5)

	}

	@And("I scroll to button add")
	def I_scroll_to_button_add() {
		WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/btn_add'), 5)

	}
	
	@And("I close pop up screening")
	def I_close_pop_up_screening() {
		WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/btn_add'), 5)
		
		WebUI.click(findTestObject('Object Repository/FO/Registration/button_Cancel'))

	}

	@And("I click save registration detail")
	def I_click_save_registration_detail() {
		WebUI.click(findTestObject('Object Repository/FO/Registration/btn_save'))
	}

	@And("I click post registration")
	def I_click_post_registration() {
		WebUI.click(findTestObject('Object Repository/FO/Registration/btn_post'))
	}
	
	@And("I click Yes on pop up confirmation")
	def I_click_yes_on_pop_up() {
		WebUI.click(findTestObject('Object Repository/FO/Registration/button_Yes'))
	}

	@And("I click back")
	def I_click_back() {
		WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/btn_back'), 5)

		WebUI.click(findTestObject('Object Repository/FO/Registration/btn_back'))
	}

	@Then("registration data created")
	def Registration_data_created() {
		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id = 'swal2-html-container' and (text() = 'Record has been created.' or . = 'Record has been created.')]"), 10)
		def text = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id = 'swal2-html-container' and (text() = 'Record has been created.' or . = 'Record has been created.')]"))
		WebUI.verifyMatch(text, 'Record has been created.', true)

		WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h4[(text() = 'Registration Info' or . = 'Registration Info')]"), 5)

		def regisStatus = WebUI.getText(findTestObject('Object Repository/FO/Appointment/label_registrationStatus'))
		WebUI.verifyMatch(regisStatus, 'Waiting', true)

		queuingNo = WebUI.getText(findTestObject('Object Repository/FO/Appointment/label_queuingNo'))
		GlobalVariable.queuingNo = WebUI.getText(findTestObject('Object Repository/FO/Appointment/label_queuingNo'))
		println(queuingNo)

	}
}