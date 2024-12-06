package patient
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
import junit.framework.Assert

import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class PatientMembership {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */

	int rows_count

	@When("I click tab membership")
	def I_click_tab_gmembership() {
		WebUI.delay(2)

		WebUI.click(findTestObject('Object Repository/FO/Patient/Patient Membership/a_Membership'))
	}

	@And("I click add membership")
	def I_click_add_membership() {
		WebUI.click(findTestObject('Object Repository/FO/Patient/Patient Membership/button_Add Member'))
	}

	@And("i input all membership field")
	def I_input_all_membership_field() {
		WebUI.click(findTestObject('Object Repository/FO/Patient/Patient Membership/select_membership'))

		//WebUI.setText(findTestObject('Object Repository/FO/Patient/Patient Membership/input_search'), 'Direksi')

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//li[(text() = \'DISKON KARYAWAN\' or . = \'DISKON KARYAWAN\')]'))


	}

	@And("I click save membership")
	def I_click_save_membership() {
		WebUI.scrollToElement(findTestObject('Object Repository/FO/Patient/Patient Membership/button_Save'), 0)

		WebUI.click(findTestObject('Object Repository/FO/Patient/Patient Membership/button_Save'))
	}

	@And("I approve request")
	def I_approve_request() {
		CucumberKW.runFeatureFileWithTags('Include/features/GS/Membership/MembershipApproval.feature', '@MembershipApproval')

		WebUI.closeBrowser()
	}

	@And("I edit membership data")
	def I_edit_membership() {
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//div[@id=\'membership_id\']/span'))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//li[(text() = \'Erha Silver Card Company\' or . = \'Erha Silver Card Company\')]'))

		WebUI.clearText(new TestObject().addProperty('id', ConditionType.EQUALS, 'membership_reff_no'))

		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, 'membership_reff_no'), '324355127178')
	}

	@And("status is Waiting Add Approval")
	def I_status_waiting_approval() {
		WebDriver driver = DriverFactory.getWebDriver()
		//'To locate table'
		WebElement Table = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[2]/div[4]/div/div/div[2]/div/div/div[2]/div/div/table/tbody"))
		//'To locate rows of table it will Capture all the rows available in the table'
		List<WebElement> rows_table = Table.findElements(By.tagName('tr'))
		//'To calculate no of rows In table'

		rows_count = rows_table.size()

		for (int row = 0; row < rows_count; row++) {
			//'To locate columns(cells) of that specific row'
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName('td'))

			//'To calculate no of columns(cells) In that specific row'
			int columns_count = Columns_row.size()
			String status = Columns_row.get(6).getText()
			Assert.assertEquals('Waiting Add Approval', status)
		}
	}

	@And("status is Waiting Delete Approval")
	def I_status_waiting_delete_approval() {
		WebDriver driver = DriverFactory.getWebDriver()
		//'To locate table'
		WebElement Table = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[2]/div[4]/div/div/div[2]/div/div/div[2]/div/div/table/tbody"))
		//'To locate rows of table it will Capture all the rows available in the table'
		List<WebElement> rows_table = Table.findElements(By.tagName('tr'))
		//'To calculate no of rows In table'

		rows_count = rows_table.size()

		for (int row = 0; row < rows_count; row++) {
			//'To locate columns(cells) of that specific row'
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName('td'))

			//'To calculate no of columns(cells) In that specific row'
			int columns_count = Columns_row.size()
			String status = Columns_row.get(6).getText()
			Assert.assertEquals('Waiting Delete Approval', status)
		}
	}

	@And("I click delete membership")
	def I_click_delete_membership() {
		WebDriver driver = DriverFactory.getWebDriver()
		//'To locate table'
		WebElement Table = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[2]/div[4]/div/div/div[2]/div/div/div[2]/div/div/table/tbody"))
		//'To locate rows of table it will Capture all the rows available in the table'
		List<WebElement> rows_table = Table.findElements(By.tagName('tr'))
		//'To calculate no of rows In table'

		rows_count = rows_table.size()

		for (int row = 0; row < rows_count; row++) {
			//'To locate columns(cells) of that specific row'
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName('td'))

			//'To calculate no of columns(cells) In that specific row'
			int columns_count = Columns_row.size()
			String status = Columns_row.get(6).getText()
			if(status.equals('Ready to Use')) {
				WebUI.scrollToElement(findTestObject('Object Repository/FO/Patient/Patient Membership/button_Delete'), 5)
				WebUI.click(findTestObject('Object Repository/FO/Patient/Patient Membership/button_Delete'))
			}

		}

	}

	@Then("membership succesfully added")
	def membership_succesfully_added() {
		WebDriver driver = DriverFactory.getWebDriver()
		//'To locate table'
		WebElement Table = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[2]/div[4]/div/div/div[2]/div/div/div[2]/div/div/table/tbody"))
		//'To locate rows of table it will Capture all the rows available in the table'
		List<WebElement> rows_table = Table.findElements(By.tagName('tr'))
		//'To calculate no of rows In table'

		rows_count = rows_table.size()

		Assert.assertTrue(rows_count  > 0 );
	}


	@Then("Membership succesfully updated")
	def membership_succesfully_updated() {
		WebDriver driver = DriverFactory.getWebDriver()
		//'To locate table'
		WebElement Table = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[2]/div[4]/div/div/div[2]/div/div/div[2]/div/div/table/tbody"))
		//'To locate rows of table it will Capture all the rows available in the table'
		List<WebElement> rows_table = Table.findElements(By.tagName('tr'))
		//'To calculate no of rows In table'

		rows_count = rows_table.size()

		Assert.assertTrue(rows_count  > 0 );
	}
}