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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword

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

import customkeyword.click

import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW



class RegistrationList {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */

	def diagnosis = findTestData("Medical Record/Diagnosis_data")
	def prescription = findTestData("Medical Record/Prescription Standard")
	def referral = findTestData("Medical Record/Referral")
	def documentphoto = findTestData("Medical Record/Dokumen dan Foto")
	def registration = findTestData("Registration/registration_data")
	int rows_count2

	@Given("I open Registration List Menu")
	def I_open_registration_list_menu() {
		WebUI.click(findTestObject('Object Repository/Medical Record/a_serviceActivity'))
		WebUI.click(findTestObject('Object Repository/Medical Record/a_registrationList'))
	}

	@Given("Patient already register consultation")
	def patient_already_register_consultation() {
		CucumberKW.runFeatureFileWithTags('Include/features/Front Office/Registration/RegistrationConsultation.feature', '@Consultation')
	}

	@And("Doctor already input service activity information")
	def doctor_already_input_service_Activity() {
		CucumberKW.runFeatureFileWithTags('Include/features/Medical Record/Registration List/RegistrationList.feature', '@DoctorConsultation')
	}

	@And("I search registration data")
	def I_search_registration_data() {
		WebUI.focus(findTestObject('Object Repository/Medical Record/Registration List/txt_search'))
		WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List/txt_search'), GlobalVariable.queuingNo)
		//WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List/txt_search'), 'A007')
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/btn_search'))
	}

	@And("I verify registration data")
	def I_verify_registration_data() {
		WebUI.scrollToElement(findTestObject('Object Repository/Medical Record/Registration List/a_registration_info'), 5)
		def RegisNo = WebUI.getAttribute(findTestObject('Object Repository/Medical Record/Registration List/label_registrationNo'), 'value')
		println(RegisNo)
		def QueuingNo = WebUI.getAttribute(findTestObject('Object Repository/Medical Record/Registration List/label_queuingNo'), 'value')
		println(QueuingNo)
	}

	@And("I open service activity detail - first row")
	def I_open_service_activity_detail_firstrow() {
		WebUI.scrollToElement(findTestObject('Object Repository/Medical Record/Registration List/a_service_activity'), 5)

		WebDriver driver2 = DriverFactory.getWebDriver()
		//'To locate table'
		WebElement Table2 = driver2.findElement(By.xpath("//*[@id='serviceActivityTable']/div[1]/table/tbody"))
		//'To locate rows of table it will Capture all the rows available in the table'
		List<WebElement> rows_table2 = Table2.findElements(By.tagName('tr'))
		//'To calculate no of rows In table'
		if(rows_table2.size()==3) {
			rows_count2 = rows_table2.size()-2
		}
		else if(rows_table2.size()==2) {
			rows_count2 = rows_table2.size()-1
		}
		else {
			rows_count2 = rows_table2.size()
		}


		for (int row2 = 0; row2 < rows_count2; row2++) {
			//'To locate columns(cells) of that specific row'
			List<WebElement> Columns_row2 = rows_table2.get(row2).findElements(By.tagName('td'))

			//'To calculate no of columns(cells) In that specific row'
			int columns_count = Columns_row2.size()

			//'Loop will execute till the last cell of that specific row'
			for (int column = 0; column < columns_count; column++) {

				if(row2 == 0 && column == 11) {
					WebUI.scrollToElement(findTestObject('Object Repository/Medical Record/Registration List/button_select_firstrow'), 5)
					WebUI.scrollToElement(findTestObject('Object Repository/Medical Record/Registration List/button_add_service_activity'), 5)
					WebUI.waitForElementClickable(findTestObject('Object Repository/Medical Record/Registration List/button_select_firstrow'), 10)
					WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/button_select_firstrow'))
				}
			}
		}
	}

	@And("I open service activity detail - second row")
	def I_open_service_activity_detail_secondrow() {
		WebUI.scrollToElement(findTestObject('Object Repository/Medical Record/Registration List/a_service_activity'), 5)

		WebDriver driver2 = DriverFactory.getWebDriver()
		//'To locate table'
		WebElement Table2 = driver2.findElement(By.xpath("//*[@id='serviceActivityTable']/div[1]/table/tbody"))
		//'To locate rows of table it will Capture all the rows available in the table'
		List<WebElement> rows_table2 = Table2.findElements(By.tagName('tr'))
		//'To calculate no of rows In table'
		if(rows_table2.size()==3) {
			rows_count2 = rows_table2.size()-1
		}
		else {
			rows_count2 = rows_table2.size()
		}


		for (int row2 = 0; row2 < rows_count2; row2++) {
			//'To locate columns(cells) of that specific row'
			List<WebElement> Columns_row2 = rows_table2.get(row2).findElements(By.tagName('td'))

			//'To calculate no of columns(cells) In that specific row'
			int columns_count = Columns_row2.size()

			//'Loop will execute till the last cell of that specific row'
			for (int column = 0; column < columns_count; column++) {

				if(row2 == 1 && column == 11) {
					WebUI.scrollToElement(findTestObject('Object Repository/Medical Record/Registration List/button_select_secondrow'), 5)
					WebUI.waitForElementClickable(findTestObject('Object Repository/Medical Record/Registration List/button_select_secondrow'), 10)
					WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/button_select_secondrow'))
				}
			}
		}
	}

	@And("I open service activity detail - third row")
	def I_open_service_activity_detail_thirdrow() {
		WebUI.scrollToElement(findTestObject('Object Repository/Medical Record/Registration List/a_service_activity'), 5)

		WebDriver driver2 = DriverFactory.getWebDriver()
		//'To locate table'
		WebElement Table2 = driver2.findElement(By.xpath("//*[@id='serviceActivityTable']/div[1]/table/tbody"))
		//'To locate rows of table it will Capture all the rows available in the table'
		List<WebElement> rows_table2 = Table2.findElements(By.tagName('tr'))
		//'To calculate no of rows In table'
		rows_count2 = rows_table2.size()

		for (int row2 = 0; row2 < rows_count2; row2++) {
			//'To locate columns(cells) of that specific row'
			List<WebElement> Columns_row2 = rows_table2.get(row2).findElements(By.tagName('td'))

			//'To calculate no of columns(cells) In that specific row'
			int columns_count = Columns_row2.size()

			//'Loop will execute till the last cell of that specific row'
			for (int column = 0; column < columns_count; column++) {

				if(row2 == 2 && column == 11) {
					WebUI.scrollToElement(findTestObject('Object Repository/Medical Record/Registration List/button_select_thirdrow'), 5)
					WebUI.waitForElementClickable(findTestObject('Object Repository/Medical Record/Registration List/button_select_thirdrow'), 10)
					WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/button_select_thirdrow'))
				}
			}
		}
	}

	@And("I open service activity detail")
	def I_open_service_activity_detail() {
		WebUI.scrollToElement(findTestObject('Object Repository/Medical Record/Registration List/a_service_activity'), 5)
		WebUI.scrollToElement(findTestObject('Object Repository/Medical Record/Registration List/button_select'), 5)
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/button_select'))
	}

	@And("I input service activity information")
	def I_input_service_activity_information() {
		WebUI.scrollToElement(findTestObject('Object Repository/Medical Record/Registration List/a_service_activity_information'), 5)
		WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List/textarea_note'), 'Consultation')
		WebUI.setText(findTestObject('Object Repository/FO/Registration/txt_next_schedule'), '3')
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/btn_proses'))
	}

	@And("I input service activity detail - diagnosis")
	def I_input_service_activity_detail_diagnosis() {
		WebUI.scrollToElement(findTestObject('Object Repository/Medical Record/Registration List/a_service_activity_detail'), 5)
		//WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/a_service_activity_detail'))
		WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List/Diagnosis/textarea_Objective'), diagnosis.getValue('Objective', 1))
		WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List/Diagnosis/textarea_subjective'), diagnosis.getValue('Subjective', 1))
		WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List/Diagnosis/textarea_plan'), diagnosis.getValue('Plan', 1))
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Diagnosis/button_assessment'))
		WebUI.delay(2)
		WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List/Diagnosis/textbox_assessment_search'), diagnosis.getValue('Assesment', 1))
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Diagnosis/button_search_assessment'))
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Diagnosis/checkbox_data_assessment'))
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Diagnosis/button_Done'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Diagnosis/button_Save'))
	}

	@And("I input service activity detail - Medical Plan")
	def I_input_service_activity_detail_medical_plan() {
		WebUI.scrollToElement(findTestObject('Object Repository/Medical Record/Registration List/a_service_activity_detail'), 5)
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Medical Plan/a_Medical Plan'))
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Medical Plan/button_Add'))
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Medical Plan/dropdown_service_activity'))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = 'Reguler Treatment' or . = 'Reguler Treatment')]"))
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Medical Plan/dropdown_product_service'))
		WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List/Medical Plan/textbox_service_activity'), 'Single Hydra Oil Clarifying Facial')
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = 'Single Hydra Oil Clarifying Facial' or . = 'Single Hydra Oil Clarifying Facial')]"))
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Medical Plan/dropdown_ruangan'))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = 'Ruang Reguler Treatment 1 - Bed 1 - 13:00 - 13:30' or . = 'Ruang Reguler Treatment 1 - Bed 1 - 13:00 - 13:30')]"))
		WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List/Medical Plan/textarea_note'), 'Coba')
		WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List/Medical Plan/textbox_interval_qty'), '1')
		WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List/Medical Plan/textbox_interval'), '1')
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Medical Plan/button_Save'))
	}

	@And("I input service activity - Treatment Log Book")
	def I_input_service_activity_treatment_log() {
		WebUI.scrollToElement(findTestObject('Object Repository/Medical Record/Registration List/a_service_activity_detail'), 5)
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Treatment Log Book/a_Treatment Log Book'))
		WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List/Treatment Log Book/textarea_note'), 'Tes')
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Treatment Log Book/button_Save'))
	}

	@And("I input service activity - Item Used")
	def I_input_service_activity_item_used() {
		WebUI.scrollToElement(findTestObject('Object Repository/Medical Record/Registration List/a_service_activity_detail'), 5)
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Item Used/a_Item Used'))
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Item Used/button_Add'))
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Item Used/dropdown_item'))
		WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List/Item Used/textbox_item_name'), 'Masker Medis')
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = 'Masker Medis' or . = 'Masker Medis')]"))
		WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List/Item Used/input_quantity'), '1')
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Item Used/button_Save'))
	}

	@And("I input service activity - Foto & Document")
	def I_input_service_activity_foto_document() {
		WebUI.scrollToElement(findTestObject('Object Repository/Medical Record/Registration List/a_service_activity_detail'), 5)
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Foto dan Dokumen/a_foto_document'))
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Foto dan Dokumen/dropdown_photo_type'))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+documentphoto.getValue('Photo_type', 1)+"' or . = '"+documentphoto.getValue('Photo_type', 1)+"')]"))
		WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List/Foto dan Dokumen/textarea_document_desc'), documentphoto.getValue('Document_description', 1))
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Foto dan Dokumen/button_choose'))
		WebUI.delay(2)
		new uploadFileKey().uploadFile(findTestObject('Object Repository/Medical Record/Registration List/Foto dan Dokumen/button_upload_doc'), 'D:\\#01. Data Kerja\\Capture 2.jpg')
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Foto dan Dokumen/button_upload_all'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Foto dan Dokumen/button_close'))
	}

	@And("I input service activity - Photo & Document")
	def I_input_service_activity_photo_document() {
		WebUI.scrollToElement(findTestObject('Object Repository/Medical Record/Registration List/a_service_activity_detail'), 5)
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Foto dan Dokumen/a_photo_document'))
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Foto dan Dokumen/dropdown_photo_type'))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+documentphoto.getValue('Photo_type', 1)+"' or . = '"+documentphoto.getValue('Photo_type', 1)+"')]"))
		WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List/Foto dan Dokumen/textarea_document_desc'), documentphoto.getValue('Document_description', 1))
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Foto dan Dokumen/button_choose'))
		WebUI.delay(2)
		new uploadFileKey().uploadFile(findTestObject('Object Repository/Medical Record/Registration List/Foto dan Dokumen/button_upload_doc'), 'D:\\#01. Data Kerja\\Capture 2.jpg')
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Foto dan Dokumen/button_upload_all'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Foto dan Dokumen/button_close'))
	}

	@And("I input service activity - Prescription Standard")
	def I_input_service_activity_prescription_standard() {
		WebUI.scrollToElement(findTestObject('Object Repository/Medical Record/Registration List/a_service_activity_detail'), 5)
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Prescription/a_Prescription'))

		WebDriver driver = DriverFactory.getWebDriver()
		//'To locate table'
		WebElement Table = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/fieldset[2]/div/div/div[2]/div[2]/div/div[1]/div/div[1]/table/tbody"))
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

				if(row == 0) {
					if(column == 3) {
						//Columns_row.get(3).click()
						WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Prescription/button_Select'))
					}
				}
			}
		}

		WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List/Prescription/textbox_product_service'), prescription.getValue('Product_service', 1))
		//WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+prescription.getValue('Product_service', 1)+"' or . = '"+prescription.getValue('Product_service', 1)+"')]"))
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Prescription/li_product_service'))
		WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List/Prescription/textbox_quantity'), prescription.getValue('Quantity', 1))
		WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List/Prescription/textbox_signa'), prescription.getValue('Signa', 1))
		WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List/Prescription/textbox_iter'), prescription.getValue('Iter', 1))
		WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List/Prescription/textbox_remarks'), prescription.getValue('Remarks', 1))
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Prescription/button_Add'))
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Prescription/button_close'))
	}

	@And("I input service activity - Referal")
	def I_input_service_activity_referal() {
		WebUI.scrollToElement(findTestObject('Object Repository/Medical Record/Registration List/a_service_activity_detail'), 5)
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Referal/a_Referral'))
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Referal/button_Add'))
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Referal/dropdown_letter_type'))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+referral.getValue('Letter_type', 1)+"' or . = '"+referral.getValue('Letter_type', 1)+"')]"))
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Referal/dropdown_referal_doctor'))
		WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List/Referal/textbox_referal_doctor'),referral.getValue('Referral_doctor', 1))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+referral.getValue('Referral_doctor', 1)+"' or . = '"+referral.getValue('Referral_doctor', 1)+"')]"))
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Referal/dropdown_service_activity'))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+referral.getValue('Service_activity', 1)+"' or . = '"+referral.getValue('Service_activity', 1)+"')]"))
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Referal/dropdown_product_service'))
		WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List/Referal/textbox_product_service'),referral.getValue('Product_service', 1))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+referral.getValue('Product_service', 1)+"' or . = '"+referral.getValue('Product_service', 1)+"')]"))
		WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List/Referal/textarea_diagnose'),referral.getValue('Diagnose', 1))
		WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List/Referal/textarea_referral_note'),referral.getValue('Referral_notes', 1))
		WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List/Referal/textbox_interval'),referral.getValue('Interval', 1))
		WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List/Referal/textbox_interval_qty'),referral.getValue('Interval_quantity', 1))
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Referal/button_Save'))
	}

	@And("I input service activity - Referral")
	def I_input_service_activity_referral() {
		WebUI.scrollToElement(findTestObject('Object Repository/Medical Record/Registration List/a_service_activity_detail'), 5)
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Referal/a_Referral'))
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Referal/button_Add'))
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Referal/dropdown_letter_type'))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+referral.getValue('Letter_type', 2)+"' or . = '"+referral.getValue('Letter_type', 2)+"')]"))
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Referal/dropdown_referal_doctor'))
		WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List/Referal/textbox_referal_doctor'),referral.getValue('Referral_doctor', 2))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+referral.getValue('Referral_doctor', 2)+"' or . = '"+referral.getValue('Referral_doctor', 2)+"')]"))
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Referal/dropdown_service_activity'))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+referral.getValue('Service_activity', 2)+"' or . = '"+referral.getValue('Service_activity', 2)+"')]"))
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Referal/dropdown_product_service'))
		WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List/Referal/textbox_product_service'),referral.getValue('Product_service', 2))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+referral.getValue('Product_service', 2)+"' or . = '"+referral.getValue('Product_service', 2)+"')]"))
		WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List/Referal/textarea_diagnose'),referral.getValue('Diagnose', 2))
		WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List/Referal/textarea_referral_note'),referral.getValue('Referral_notes', 2))
		WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List/Referal/textbox_interval'),referral.getValue('Interval', 2))
		WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List/Referal/textbox_interval_qty'),referral.getValue('Interval_quantity', 2))
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/Referal/button_Save'))
	}

	@And("I click add service activity")
	def I_click_add_service_activity() {
		WebUI.scrollToElement(findTestObject('Object Repository/Medical Record/Registration List/a_service_activity'), 5)
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/button_add_service_activity'))
	}

	@And("I input new activity treatment")
	def I_input_new_activity_treatment() {
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/New Service Activity/dropdown_service_activity'))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+registration.getValue('Service_activity', 3)+"' or . = '"+registration.getValue('Service_activity', 3)+"')]"))
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/New Service Activity/dropdown_product_service'))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+registration.getValue('Product_service', 3)+"' or . = '"+registration.getValue('Product_service', 3)+"')]"))

		//validate staff name
		def staffName = WebUI.getText(findTestObject('Object Repository/Medical Record/Registration List/New Service Activity/textbox_staffname'))
		print(staffName)
		WebUI.verifyMatch(staffName, 'AutoDok', false)

		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/New Service Activity/dropdown_room_time'))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+registration.getValue('schedule', 3)+"' or . = '"+registration.getValue('schedule', 3)+"')]"))

		WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List/New Service Activity/textarea_note'), 'Tes')

		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/New Service Activity/button_Save'))
	}

	@And("I input new activity consultation")
	def I_input_new_activity_consultation() {
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/New Service Activity/dropdown_service_activity'))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+registration.getValue('Service_activity', 1)+"' or . = '"+registration.getValue('Service_activity', 1)+"')]"))
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/New Service Activity/dropdown_product_service'))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+registration.getValue('Product_service', 1)+"' or . = '"+registration.getValue('Product_service', 1)+"')]"))

		//validate staff name
		def staffName = WebUI.getText(findTestObject('Object Repository/Medical Record/Registration List/New Service Activity/textbox_staffname'))
		print(staffName)
		WebUI.verifyMatch(staffName, 'AutoDok', false)

		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/New Service Activity/dropdown_room_time'))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+registration.getValue('schedule', 1)+"' or . = '"+registration.getValue('schedule', 1)+"')]"))

		WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List/New Service Activity/textarea_note'), 'Tes')

		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/New Service Activity/button_Save'))
	}

	@And("I input new activity regular treatment")
	def I_input_new_activity_regular_treatment() {
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/New Service Activity/dropdown_service_activity'))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+registration.getValue('Service_activity', 2)+"' or . = '"+registration.getValue('Service_activity', 2)+"')]"))
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/New Service Activity/dropdown_product_service'))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+registration.getValue('Product_service', 2)+"' or . = '"+registration.getValue('Product_service', 2)+"')]"))

		//validate staff name
		def staffName = WebUI.getText(findTestObject('Object Repository/Medical Record/Registration List/New Service Activity/textbox_staffname'))
		print(staffName)
		WebUI.verifyMatch(staffName, 'Input name', false)

		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/New Service Activity/dropdown_room_time'))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+registration.getValue('schedule', 2)+"' or . = '"+registration.getValue('schedule', 2)+"')]"))

		WebUI.setText(findTestObject('Object Repository/Medical Record/Registration List/New Service Activity/textarea_note'), 'Tes')

		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/New Service Activity/button_Save'))
	}

	@And("I select service activity")
	def I_select_service_activity() {
		WebUI.scrollToElement(findTestObject('Object Repository/Medical Record/Registration List/button_view_medical_plan'), 5)

		WebDriver driver2 = DriverFactory.getWebDriver()
		//'To locate table'
		WebElement Table2 = driver2.findElement(By.xpath("//*[@id='serviceActivityTable']/div[1]/table/tbody"))
		//'To locate rows of table it will Capture all the rows available in the table'
		List<WebElement> rows_table2 = Table2.findElements(By.tagName('tr'))
		//'To calculate no of rows In table'

		rows_count2 = rows_table2.size()

		for (int row2 = 0; row2 < rows_count2; row2++) {
			//'To locate columns(cells) of that specific row'
			List<WebElement> Columns_row2 = rows_table2.get(row2).findElements(By.tagName('td'))

			//'To calculate no of columns(cells) In that specific row'
			int columns_count = Columns_row2.size()

			//'Loop will execute till the last cell of that specific row'
			for (int column = 0; column < columns_count; column++) {

				if(row2 == 0 && column == 0) {
					Columns_row2.get(0).click()
				}
			}
		}
		WebUI.scrollToElement(findTestObject('Object Repository/Medical Record/Registration List/label_queuingNo'), 5)
		WebUI.scrollToPosition(999, 100)
		//WebUI.scrollToElement(findTestObject('Object Repository/Page_CIS Train/button_bulk_delete'), 5)
	}

	@And("I click done")
	def I_click_done() {
		WebUI.scrollToElement(findTestObject('Object Repository/Medical Record/Registration List/a_service_activity_detail'), 5)
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/button_Done'))
	}

	@And("I click finish")
	def I_click_finish() {
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/button_Finish'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/button_Yes'))
	}

	@And("post registration data")
	def post_registration_data() {
		WebUI.scrollToElement(findTestObject('Object Repository/Medical Record/Registration List/h4_Service Activity Detail Form'), 5)
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/button_Post'))
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/button_Back'))
	}

	@And("I back to registration list detail")
	def I_back_to_registration_list_detail() {
		WebUI.scrollToPosition(0, 0)
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/button_Back'))
	}

	@Then("Status change to Done")
	def Status_change_to_done() {
		WebUI.scrollToElement(findTestObject('Object Repository/Medical Record/Registration List/a_service_activity'), 5)

		WebDriver driver = DriverFactory.getWebDriver()
		//'To locate table'
		WebElement Table = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/div[3]/fieldset/div/div/div[2]/div[1]/table/tbody"))
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

				if(column == 8) {
					WebUI.verifyMatch(celltext, 'Done', true)
				}
			}
		}
	}

	@Then("Status Service change to Done")
	def Status_service_change_to_done() {
		WebUI.scrollToElement(findTestObject('Object Repository/Medical Record/Registration List/a_service_activity'), 5)

		WebDriver driver = DriverFactory.getWebDriver()
		//'To locate table'
		WebElement Table = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/div[3]/fieldset/div/div/div[2]/div[1]/table/tbody"))
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

				if(column == 8) {
					WebUI.verifyMatch(celltext, 'Done', true)
				}
			}
		}
	}

	@When("I open registration list detail")
	def I_open_registration__list_detail() {
		WebUI.scrollToElement(findTestObject('Object Repository/Medical Record/Registration List/btn_refresh'), 5)
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/button_select'))
	}

	@Then("Service activity success inputed")
	def service_activity_inputed() {
		WebUI.scrollToPosition(0, 0)
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/button_Back'))
		WebUI.scrollToPosition(0, 0)
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/button_Back'))
	}

	@Then("Success input service activity detail")
	def success_input_service_activity_detail() {
		WebUI.scrollToPosition(0, 0)
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/button_Back'))
		WebUI.scrollToPosition(0, 0)
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/button_Back'))
	}

	@Then("Success finish data")
	def success_finish_data() {
		WebUI.scrollToPosition(0, 0)
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/button_Back'))
	}

	@Then("New service activity has been created")
	def New_service_activity_has_created() {
		WebUI.scrollToPosition(0, 0)
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/button_Back'))
	}

	@Then("New service activity has deleted")
	def New_service_activity_has_deleted() {

		WebDriver driver = DriverFactory.getWebDriver()
		//'To locate table'
		WebElement Table = driver.findElement(By.xpath("//*[@id='serviceActivityTable']/div[1]/table/tbody"))
		//'To locate rows of table it will Capture all the rows available in the table'
		List<WebElement> rows_table = Table.findElements(By.tagName('tr'))
		//'To calculate no of rows In table'


		def	rows_count = rows_table.size()
		assert rows_count == rows_count2-1

		WebUI.scrollToPosition(0, 0)
		WebUI.click(findTestObject('Object Repository/Medical Record/Registration List/button_Back'))
	}
}