package membership
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
import junit.framework.Assert

import com.kms.katalon.core.main.CustomKeywordDelegatingMetaClass

import org.openqa.selenium.Keys as Keys



class Membership {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	def membership = findTestData("Membership/Membership_data")
	def membership_company = findTestData("Membership/Membership_company_info")
	def membership_branch = findTestData("Membership/Membership_branch")
	def membership_productservice = findTestData("Membership/Membership_productservice")
	def patient = findTestData("Patient/Patient_data")
	int rows_count

	@Given("I open membership page")
	def I_open_membership_page() {
		WebUI.click(findTestObject("Object Repository/General Setup/Membership/a_Marketing"))
		WebUI.click(findTestObject("Object Repository/General Setup/Membership/a_Membership"))
	}

	@When("I already open general setup page")
	def I_already_open_general_setup_page() {
		WebUI.click(findTestObject("Object Repository/General Setup/Membership/div_General Setup"))
	}

	@When("I click add membership button")
	def I_click_add_membership_button() {
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//span[(text() = 'Add' or . = 'Add')]"))
	}

	@When("I search membership data")
	def I_search_membership_data() {
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@placeholder = 'Search...']"), 'DISKON KARYAWAN')
		WebUI.click(findTestObject("Object Repository/General Setup/Membership/button_search"))
	}

	@When("I click delete branch")
	def I_click_delete_branch() {
		WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[(text() = 'Add Branch ' or . = 'Add Branch ')]"), 3)
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[(text() = 'Delete' or . = 'Delete')]"))
	}

	@When("I click add branch")
	def I_click_add_branch(){
		WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h4[(text() = 'Term & Condition' or . = 'Term & Condition')]"), 3)
		WebUI.enhancedClick(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div/div[2]/div/div/button"))
	}

	@When("I click add product service")
	def I_click_add_product_service() {
		WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[(text() = 'Product & Service' or . = 'Product & Service')]"), 5)
		WebUI.enhancedClick(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[@type = 'button' and (text() = 'Add Product & Service' or . = 'Add Product & Service')]"))
	}

	@When("I click delete product service")
	def I_click_delete_product_service() {
		WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[(text() = 'Product & Service' or . = 'Product & Service')]"), 3)
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[3]/div/div[3]/div/div/table/tbody/tr/td[8]/div/button"))
	}

	@When("I edit membership")
	def I_edit_membership() {
		WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h4[(text() = 'Data Information' or . = 'Data Information')]"), 3)
		WebUI.click(new TestObject().addProperty('id', ConditionType.EQUALS, "type"))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = 'Platinum' or . = 'Platinum')]"))
	}

	@When ("I click select branch")
	def I_click_select_branch() {
		WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h4[(text() = 'Term & Condition' or . = 'Term & Condition')]"), 3)
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[@type = 'button' and @name = 'row-edit']"))
	}

	@When("I click select product service")
	def I_click_select_product_service() {
		WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[(text() = 'Product & Service' or . = 'Product & Service')]"), 3)
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[3]/div/div[3]/div/div/table/tbody/tr/td[9]/button"))
	}

	@When("I click delete button")
	def I_click_delete_button() {
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[(text() = 'Delete' or . = 'Delete')]"))
	}

	@When("I click yes button")
	def I_click_yes_button() {
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[(text() = 'Yes' or . = 'Yes')]"))
	}

	@When("I already open membership detail")
	def I_already_open_membership_detail() {
		WebUI.verifyMatch(WebUI.getUrl(), 'https://cis-general-setup-staging.aryanoble.web.id/#/membership-update', true)
	}

	@When("I select membership data")
	def I_select_membership_data() {
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div[2]/div/div/table/tbody/tr/td"))
	}

	@When("I search membership branch")
	def I_search_membership_branch() {
		WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h4[(text() = 'Term & Condition' or . = 'Term & Condition')]"), 3)
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@placeholder = 'Search...']"), 'Ultimate BSD')
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div/div[2]/div/div[3]/button/span"))
	}

	@When("I search invalid branch data")
	def I_search_invalid_branch_data() {
		WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h4[(text() = 'Term & Condition' or . = 'Term & Condition')]"), 3)
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@placeholder = 'Search...']"), 'ES - Jambi')
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div/div[2]/div/div[3]/button/span"))
	}

	@When("I search membership product service")
	def I_search_membership_product_service() {
		WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[(text() = 'Product & Service' or . = 'Product & Service')]"), 3)
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[3]/div/div[2]/div/div[3]/input"), 'All Product & Service')
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[3]/div/div[2]/div/div[3]/button"))
	}

	@When("I inactive membership status")
	def I_inactive_membership_status() {
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='status']/span"))
	}

	@When("I search invalid product service data")
	def I_search_invalid_product_service_data() {
		WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[(text() = 'Product & Service' or . = 'Product & Service')]"), 3)
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[3]/div/div[2]/div/div[3]/input"), 'spuit 3 cc')
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[3]/div/div[2]/div/div[3]/button"))
	}
	@And("I input data information field with individu category")
	def I_input_data_information_field_with_individu_category() {
		WebUI.delay(3)
		WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h4[(text() = 'Data Information' or . = 'Data Information')]"), 3)
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@id = 'code' and @type = 'text' and @placeholder = 'Input membership code']"), membership.getValue('Membership_code', 1))
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@id = 'name' and @type = 'text' and @placeholder = 'Input membership name']"), membership.getValue('Membership_name', 1))
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@id = 'description' and @type = 'text' and @placeholder = 'Input description']"), membership.getValue('Description', 1))
		WebUI.click(new TestObject().addProperty('id', ConditionType.EQUALS, "type"))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+membership.getValue('Type', 1)+"' or . = '"+membership.getValue('Type', 1)+"')]"))
		WebUI.click(new TestObject().addProperty('id', ConditionType.EQUALS, "category"))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+membership.getValue('Category', 1)+"' or . = '"+membership.getValue('Category', 1)+"')]"))
		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, "mou"), membership.getValue('MOU_no', 1))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@type = 'text' and @placeholder = 'Input start period']"))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//td[(text() = '14' or . = '14')]"))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@type = 'text' and @placeholder = 'Input end period']"))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//td[(text() = '22' or . = '22')]"))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id = 'cyclePeriod' and (text() = 'Choose cycleChoose cycle' or . = 'Choose cycleChoose cycle')]"))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+membership.getValue('Cycle_period', 1)+"' or . = '"+membership.getValue('Cycle_period', 1)+"')]"))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id = 'transactionType' and (text() = 'Choose transaction typeChoose transaction type' or . = 'Choose transaction typeChoose transaction type')]"))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+membership.getValue('Transaction_type', 1)+"' or . = '"+membership.getValue('Transaction_type', 1)+"')]"))
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@id = 'plafondAmount' and @placeholder = 'Input amount']"), membership.getValue('Plafond_amount', 1))
		WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//span[(text() = 'Save' or . = 'Save')]"), 5)
	}

	@And("I input data information field with company category")
	def I_input_data_information_field_with_company_category() {
		WebUI.delay(3)
		WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h4[(text() = 'Data Information' or . = 'Data Information')]"), 3)
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@id = 'code' and @type = 'text' and @placeholder = 'Input membership code']"), membership.getValue('Membership_code', 2))
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@id = 'name' and @type = 'text' and @placeholder = 'Input membership name']"), membership.getValue('Membership_name', 2))
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@id = 'description' and @type = 'text' and @placeholder = 'Input description']"), membership.getValue('Description', 2))
		WebUI.click(new TestObject().addProperty('id', ConditionType.EQUALS, "type"))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+membership.getValue('Type', 2)+"' or . = '"+membership.getValue('Type', 2)+"')]"))
		WebUI.click(new TestObject().addProperty('id', ConditionType.EQUALS, "category"))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+membership.getValue('Category', 2)+"' or . = '"+membership.getValue('Category', 2)+"')]"))
		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, "mou"), membership.getValue('MOU_no', 2))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@type = 'text' and @placeholder = 'Input start period']"))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//td[(text() = '14' or . = '14')]"))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@type = 'text' and @placeholder = 'Input end period']"))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//td[(text() = '22' or . = '22')]"))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id = 'cyclePeriod' and (text() = 'Choose cycleChoose cycle' or . = 'Choose cycleChoose cycle')]"))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+membership.getValue('Cycle_period', 2)+"' or . = '"+membership.getValue('Cycle_period', 2)+"')]"))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id = 'transactionType' and (text() = 'Choose transaction typeChoose transaction type' or . = 'Choose transaction typeChoose transaction type')]"))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+membership.getValue('Transaction_type', 2)+"' or . = '"+membership.getValue('Transaction_type', 2)+"')]"))
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@id = 'coveragePct' and @placeholder = 'Input coverage']"), membership.getValue('Coverage_percentage', 2))
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@id = 'coverageMaxAmount' and @placeholder = 'Input coverage max']"), membership.getValue('Coverage_maxamount', 2))
		WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[(text() = 'Company Province' or . = 'Company Province')]"), 3)
		//Company Info
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/form/div[4]/div/div/div/div[2]/input"), membership_company.getValue('Company_name', 1))
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/form/div[4]/div/div/div[2]/div[2]/input"), membership_company.getValue('Company_address1', 1))
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/form/div[4]/div/div/div[3]/div[2]/input"), membership_company.getValue('Company_address2', 1))
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/form/div[4]/div/div/div[5]/div[2]/input"), membership_company.getValue('Company_rt', 1))
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/form/div[4]/div/div/div[6]/div[2]/input"), membership_company.getValue('Company_rw', 1))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//span[(text() = 'Choose' or . = 'Choose')]"))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+membership_company.getValue('Company_province',1)+"' or . = '"+membership_company.getValue('Company_province',1)+"')]"))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/form/div[4]/div/div/div[8]/div[2]/div/div/div/button/span"))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//span[(text() = 'Select' or . = 'Select')]"))
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/form/div[4]/div[2]/div/div[3]/div[2]/div/div/input"), membership_company.getValue('Company_area', 1))
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/form/div[4]/div[2]/div/div[3]/div[2]/div/div[2]/input"), membership_company.getValue('Company_phoneno', 1))
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/form/div[4]/div[2]/div/div[4]/div[2]/div/div/input"), membership_company.getValue('Company_areafax', 1))
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/form/div[4]/div[2]/div/div[4]/div[2]/div/div[2]/input"), membership_company.getValue('Company_faxno', 1))
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/form/div[4]/div[2]/div/div[5]/div[2]/input"), membership_company.getValue('Company_picname', 1))
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/form/div[4]/div[2]/div/div[6]/div[2]/input"), membership_company.getValue('Company_picemail', 1))
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/form/div[4]/div[2]/div/div[7]/div[2]/input"), membership_company.getValue('Company_picphone', 1))
		WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/form/div/div[3]/button"), 3)

	}


	@And("I click save button")
	def I_click_save_button() {
		WebUI.enhancedClick(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//span[(text() = 'Save' or . = 'Save')]"))
	}

	@And("I approve membership request")
	def I_approve_membership_request() {
		WebUI.scrollToElement(findTestObject('Object Repository/General Setup/Membership/Member Approval'), 10)

		WebDriver driver = DriverFactory.getWebDriver()
		//'To locate table'
		WebElement Table = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[3]/div/div/div[2]/div/div/div[2]/div/table/tbody"))
		//'To locate rows of table it will Capture all the rows available in the table'
		List<WebElement> rows_table = Table.findElements(By.tagName('tr'))
		//'To calculate no of rows In table'

		rows_count = rows_table.size()

		for (int row = 0; row < rows_count; row++) {
			//'To locate columns(cells) of that specific row'
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName('td'))

			//'To calculate no of columns(cells) In that specific row'
			int columns_count = Columns_row.size()
			//get patient fullname
			def fullname = WebUI.concatenate([
				patient.getValue('Patient_First_Name', 2),
				' ',
				patient.getValue('Patient_Middle_Name', 2),
				' ',
				patient.getValue('Patient_Last_Name', 2)] as String[])
			//get data patient name
			String name = Columns_row.get(1).getText()

			if(name.equals(fullname)) {
				WebUI.click(findTestObject('Object Repository/General Setup/Membership/span_Approve'))

				WebUI.setText(findTestObject('Object Repository/General Setup/Membership/input_password'), 'Erha1!')

				WebUI.setText(findTestObject('Object Repository/General Setup/Membership/textarea_note'), 'Tes')

				WebUI.click(findTestObject('Object Repository/General Setup/Membership/button_Submit'))
			}
		}
	}


	@And("I click edit membership")
	def I_click_edit_membership() {
		WebUI.click(findTestObject("Object Repository/General Setup/Membership/button_Edit"))
	}


	@And("I input all branch field")
	def I_input_all_branch_field(){
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='branchId']/span"))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+membership_branch.getValue('Branch_name', 1)+"' or . = '"+membership_branch.getValue('Branch_name', 1)+"')]"))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='serviceActivityId']/div[3]"))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+membership_branch.getValue('Service_activity', 1)+"' or . = '"+membership_branch.getValue('Service_activity', 1)+"')]"))
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@id = 'discount' and @placeholder = 'Enter amount' and @type = 'number']"), membership_branch.getValue('Discount', 1))
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@id = 'maxDiscountAmount' and @placeholder = 'Enter amount']"), membership_branch.getValue('Max_discount', 1))
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@id = 'minTransactionAmount' and @placeholder = 'Enter amount']"), membership_branch.getValue('Min_transaction', 1))
	}

	@And("I click save branch")
	def I_click_save_branch() {
		WebUI.click(new TestObject().addProperty('class', ConditionType.EQUALS, "p-button p-component p-button-netral mr-0"))
	}

	@And("I input product service field without is apply to all")
	def I_input_product_service_field_without_is_apply_to_all () {
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='productServiceId']/span"))
		WebUI.delay(3)
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+membership_productservice.getValue('Product_service', 1)+"' or . = '"+membership_productservice.getValue('Product_service', 1)+"')]"))
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@id = 'discount' and @placeholder = 'Enter amount' and @type = 'number']"), membership_productservice.getValue('Discount', 1))
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@id = 'maxDiscountAmount' and @placeholder = 'Enter amount']"), membership_productservice.getValue('Max_discount', 1))
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@id = 'minTransactionAmount' and @placeholder = 'Enter amount']"), membership_productservice.getValue('Min_transaction', 1))
	}

	@And("I input product service field with is apply to all")
	def I_input_product_service_field_with_is_apply_to_all () {
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='productServiceId']/span"))
		WebUI.delay(3)
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+membership_productservice.getValue('Product_service', 2)+"' or . = '"+membership_productservice.getValue('Product_service', 2)+"')]"))
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@id = 'discount' and @placeholder = 'Enter amount' and @type = 'number']"), membership_productservice.getValue('Discount', 2))
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@id = 'maxDiscountAmount' and @placeholder = 'Enter amount']"), membership_productservice.getValue('Max_discount', 2))
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@id = 'minTransactionAmount' and @placeholder = 'Enter amount']"), membership_productservice.getValue('Min_transaction', 2))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id = 'isApplyToAll']"))
	}

	@And("I click save product service")
	def I_click_save_product_service() {
		WebUI.click(new TestObject().addProperty('class', ConditionType.EQUALS, "p-button p-component p-button-netral mr-0"))
	}

	@And("I edit branch")
	def I_edit_edit() {
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='service_activity_id']/span"))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = 'Consultation' or . = 'Consultation')]"))
		WebUI.clearText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div/div[3]/div/div/table/tbody/tr/td[6]/input"))
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div/div[3]/div/div/table/tbody/tr/td[6]/input"), '27')
	}

	@And("I click save editing branch")
	def I_click_save_editing_branch() {
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[@type = 'button' and @name = 'row-save']"))
	}

	@And("I edit product service")
	def I_edit_product_service() {
		WebUI.clearText(new TestObject().addProperty('class', ConditionType.EQUALS, "p-inputtext p-component p-filled w-9 w-9"))
		WebUI.setText(new TestObject().addProperty('class', ConditionType.EQUALS, "p-inputtext p-component p-filled w-9 w-9"), '31')
		WebUI.clearText(new TestObject().addProperty('class', ConditionType.EQUALS, "p-inputtext p-component p-filled w-9 w-9"))
		WebUI.setText(new TestObject().addProperty('class', ConditionType.EQUALS, "p-inputtext p-component p-filled w-9 w-9"), '655000')
	}

	@And("I click save editing product service")
	def I_click_save_editing_product_service() {
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[3]/div/div[3]/div/div/table/tbody/tr/td[9]/button"))
	}

	@And("I click bulk delete membership")
	def I_click_bulk_delete_membership() {
		WebUI.clearText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div/div[2]/div/div[3]/input"))
		WebUI.delay(3)
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@placeholder = 'Search...']"), '112215')
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div[2]/div/div/table/thead/tr/th/div/div/div"))
		//sudah beener jika delete dupplikat dataWebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div[2]/div/div/table/thead/tr/th/div/div/div"))
		//WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@placeholder = 'Search...']"), '11223346')
		WebUI.clearText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div/div[2]/div/div[3]/input"))
		//WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div[2]/div/div/table/tbody/tr[2]/td"))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[(text() = 'Bulk Delete' or . = 'Bulk Delete')]"))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[(text() = 'Yes' or . = 'Yes')]"))
	}

	@And("I search membership to delete")
	def I_search_membership_to_delete() {
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@placeholder = 'Search...']"), '11223346')
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div/div[2]/div/div[3]/button/span"))
	}

	@Then("Membership successfully added")
	def Membership_successfully_added() {
		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h2[@id = 'swal2-title' and (text() = 'Success !' or . = 'Success !')]"), 10)
		def text = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h2[@id = 'swal2-title' and (text() = 'Success !' or . = 'Success !')]"))
		WebUI.verifyMatch(text, 'Success !', true)
	}

	@Then("Branch membership succesfully added")
	def Branch_membership_successfully_added() {
		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h2[@id = 'swal2-title' and (text() = 'Success !' or . = 'Success !')]"), 5)
		def text = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h2[@id = 'swal2-title' and (text() = 'Success !' or . = 'Success !')]"))
		WebUI.verifyMatch(text, 'Success !', true)
	}

	@Then("I successfully delete membership branch")
	def I_successfully_delete_membership_branch() {
		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id = 'swal2-html-container' and (text() = 'Delete data branch success!' or . = 'Delete data branch success!')]"), 5)
		def text = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id = 'swal2-html-container' and (text() = 'Delete data branch success!' or . = 'Delete data branch success!')]"))
		WebUI.verifyMatch(text, 'Delete data branch success!', true)
	}

	@Then("Product service without is apply to all succesfully added")
	def Product_service_without_is_apply_to_all_succesfully_added() {
		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id = 'swal2-html-container' and (text() = 'Data has been saved' or . = 'Data has been saved')]"), 5)
		def text = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id = 'swal2-html-container' and (text() = 'Data has been saved' or . = 'Data has been saved')]"))
		WebUI.verifyMatch(text, 'Data has been saved', true)
	}

	@Then("Product service with is apply to all succesfully added")
	def Product_service_with_is_apply_to_all_succesfully_added() {
		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id = 'swal2-html-container' and (text() = 'Data has been saved' or . = 'Data has been saved')]"), 5)
		def text = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id = 'swal2-html-container' and (text() = 'Data has been saved' or . = 'Data has been saved')]"))
		WebUI.verifyMatch(text, 'Data has been saved', true)
	}

	@Then("Successfully display membership data")
	def Successfully_display_membership_data() {
		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//td[(text() = '12112023' or . = '12112023')]"), 3)
		def text = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//td[(text() = '12112023' or . = '12112023')]"))
		WebUI.verifyMatch(text, '12112023', true)
	}

	@Then("I successfully delete membership product service")
	def I_successfully_delete_membership_product_service() {
		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id = 'swal2-html-container' and (text() = 'Delete data product service success!' or . = 'Delete data product service success!')]"), 3)
		def text = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id = 'swal2-html-container' and (text() = 'Delete data product service success!' or . = 'Delete data product service success!')]"))
		WebUI.verifyMatch(text, 'Delete data product service success!', true)
	}

	@Then("I successfully edit membership")
	def I_successfully_edit_membership() {
		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id = 'swal2-html-container' and (text() = 'Update data membership success!' or . = 'Update data membership success!')]"), 3)
		def text = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id = 'swal2-html-container' and (text() = 'Update data membership success!' or . = 'Update data membership success!')]"))
		WebUI.verifyMatch(text, 'Update data membership success!', true)
	}

	@Then("I successfully edit branch")
	def I_successfully_edit_branch() {
		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id = 'swal2-html-container' and (text() = 'Update data branch success!' or . = 'Update data branch success!')]"), 3)
		def text = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id = 'swal2-html-container' and (text() = 'Update data branch success!' or . = 'Update data branch success!')]"))
		WebUI.verifyMatch(text, 'Update data branch success!', true)
	}

	@Then("I successfully edit product service")
	def I_successfully_edit_product_service() {
		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id = 'swal2-html-container' and (text() = 'Update data product service success!' or . = 'Update data product service success!')]"), 3)
		def text = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id = 'swal2-html-container' and (text() = 'Update data product service success!' or . = 'Update data product service success!')]"))
		WebUI.verifyMatch(text, 'Update data product service success!', true)
	}

	@Then("Successfully delete membership data")
	def Successfully_delete_membership_data() {
		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id = 'swal2-html-container' and (text() = 'Data has been deleted' or . = 'Data has been deleted')]"), 3)
		def text = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id = 'swal2-html-container' and (text() = 'Data has been deleted' or . = 'Data has been deleted')]"))
		WebUI.verifyMatch(text, 'Data has been deleted', true)
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[@type = 'button' and (text() = 'OK' or . = 'OK')]"))
	}

	@Then("Successfully bulk delete membership data")
	def Successfully_bulk_delete_membership_data() {
		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id = 'swal2-html-container' and (text() = 'Data has been deleted' or . = 'Data has been deleted')]"), 3)
		def text = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id = 'swal2-html-container' and (text() = 'Data has been deleted' or . = 'Data has been deleted')]"))
		WebUI.verifyMatch(text, 'Data has been deleted', true)
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[@type = 'button' and (text() = 'OK' or . = 'OK')]"))
	}

	@Then("Successfully display membership branch")
	def Successfully_display_membership_branch() {
		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//p[(text() = 'ES - Jambi' or . = 'ES - Jambi')]"), 3)
		def text = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//p[(text() = 'ES - Jambi' or . = 'ES - Jambi')]"))
		WebUI.verifyMatch(text, 'ES - Jambi', true)
	}

	@Then("Successfully display membership product service")
	def Successfully_display_membership_product_service() {
		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//p[(text() = 'All Product & Service' or . = 'All Product & Service')]"), 3)
		def text = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//p[(text() = 'All Product & Service' or . = 'All Product & Service')]"))
		WebUI.verifyMatch(text, 'All Product & Service', true)
	}

	@Then("Membership status is inactive")
	def Membership_status_is_inactive() {
		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id = 'swal2-html-container' and (text() = 'Update data membership success!' or . = 'Update data membership success!')]"), 3)
		def text = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id = 'swal2-html-container' and (text() = 'Update data membership success!' or . = 'Update data membership success!')]"))
		WebUI.verifyMatch(text, 'Update data membership success!', true)
	}

	@Then("Membership approval success")
	def Membership_approval_success() {

	}

	@Then("Successfully display no results found")
	def Successfully_display_no_results_found() {
		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//td[(text() = 'No results found' or . = 'No results found')]"), 3)
		def text = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//td[(text() = 'No results found' or . = 'No results found')]"))
		WebUI.verifyMatch(text, 'No Results Found', true)
	}

}