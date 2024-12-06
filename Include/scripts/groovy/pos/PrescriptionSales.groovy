package pos
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



class PrescriptionSales {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	def patient = findTestData("Patient/Patient_data")
	def directsales = findTestData("Direct Sales/DirectSales")
	BigDecimal totalPrice = new BigDecimal(0)
	BigDecimal totalAmount = new BigDecimal(0)
	BigDecimal hargaTotalDiskon = new BigDecimal(0)
	def pres_no

	@Given("I am open prescription sales page")
	def I_am_open_prescription_sales_page() {
		WebUI.click(findTestObject('Object Repository/Point Of Sales/a_Point of Sales'))
		WebUI.click(findTestObject('Object Repository/Point Of Sales/Prescription Sales/a_Prescription Sales'))
	}

	@And("I search pharmacy registration data")
	def I_search_pharmacy_registration_data() {
		WebUI.click(findTestObject('Object Repository/Point Of Sales/Prescription Sales/dropdown_search'))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = 'Queueing No' or . = 'Queueing No')]"))
		WebUI.focus(findTestObject('Object Repository/Point Of Sales/Prescription Sales/textbox_search'))
		WebUI.setText(findTestObject('Object Repository/Point Of Sales/Prescription Sales/textbox_search'), GlobalVariable.queuingNo)
		//WebUI.setText(findTestObject('Object Repository/Point Of Sales/Prescription Sales/textbox_search'), 'A011')
		WebUI.click(findTestObject('Object Repository/Point Of Sales/Prescription Sales/button_search'))
	}

	@And("I verify pharmacy registration data")
	def I_verify_pharmacy_registration_data() {
		def name = WebUI.getText(findTestObject('Object Repository/Point Of Sales/Prescription Sales/label_name'))
		def phoneNo = WebUI.getText(findTestObject('Object Repository/Point Of Sales/Prescription Sales/label_phone_no'))
		def email = WebUI.getText(findTestObject('Object Repository/Point Of Sales/Prescription Sales/label_email'))

		def fullname = WebUI.concatenate([
			patient.getValue('Patient_First_Name', 3),
			' ',
			patient.getValue('Patient_Middle_Name', 3),
			' ',
			patient.getValue('Patient_Last_Name', 3),
			' ',
			' ',
			'\\(',
			patient.getValue('Gender', 3),
			'\\)'] as String[])

		WebUI.verifyMatch(name, fullname, true)
		WebUI.verifyMatch(phoneNo, patient.getValue('no_hp', 3), true)
		WebUI.verifyMatch(email, patient.getValue('email', 3), true)
	}

	@And("I select prescription data - standard")
	def I_select_prescription_data_standard() {
		WebUI.scrollToElement(findTestObject('Object Repository/Point Of Sales/Prescription Sales/button_add_copy_prescription'), 5)

		WebDriver driver = DriverFactory.getWebDriver()
		//'To locate table'
		WebElement Table = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[4]/div[2]/div[1]/table/tbody"))
		//'To locate rows of table it will Capture all the rows available in the table'
		List<WebElement> rows_table = Table.findElements(By.tagName('tr'))
		//'To calculate no of rows In table'

		def rows_count = rows_table.size()

		for (int row = 0; row < rows_count; row++) {
			//'To locate columns(cells) of that specific row'
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName('td'))

			//'To calculate no of columns(cells) In that specific row'
			int columns_count = Columns_row.size()

			//'Loop will execute till the last cell of that specific row'
			for (int column = 0; column < columns_count; column++) {

				if(row == 1 && column == 0) {
					Columns_row.get(0).click()
				}
			}
		}
		WebUI.scrollToElement(findTestObject('Object Repository/Point Of Sales/Prescription Sales/button_next'), 5)
	}
	
	@And("I select prescription data - special")
	def I_select_prescription_data_special() {
		WebUI.scrollToElement(findTestObject('Object Repository/Point Of Sales/Prescription Sales/button_add_copy_prescription'), 5)

		WebDriver driver = DriverFactory.getWebDriver()
		//'To locate table'
		WebElement Table = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[4]/div[2]/div[1]/table/tbody"))
		//'To locate rows of table it will Capture all the rows available in the table'
		List<WebElement> rows_table = Table.findElements(By.tagName('tr'))
		//'To calculate no of rows In table'

		def rows_count = rows_table.size()

		for (int row = 0; row < rows_count; row++) {
			//'To locate columns(cells) of that specific row'
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName('td'))

			//'To calculate no of columns(cells) In that specific row'
			int columns_count = Columns_row.size()

			//'Loop will execute till the last cell of that specific row'
			for (int column = 0; column < columns_count; column++) {

				if(row == 0 && column == 0) {
					Columns_row.get(0).click()
				}
			}
		}
		WebUI.scrollToElement(findTestObject('Object Repository/Point Of Sales/Prescription Sales/button_next'), 5)
	}
	
	@And("I select prescription data - multiple")
	def I_select_prescription_data_multiple() {
		WebUI.scrollToElement(findTestObject('Object Repository/Point Of Sales/Prescription Sales/button_add_copy_prescription'), 5)

		WebDriver driver = DriverFactory.getWebDriver()
		//'To locate table'
		WebElement Table = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[4]/div[2]/div[1]/table/tbody"))
		//'To locate rows of table it will Capture all the rows available in the table'
		List<WebElement> rows_table = Table.findElements(By.tagName('tr'))
		//'To calculate no of rows In table'

		def rows_count = rows_table.size()

		for (int row = 0; row < rows_count; row++) {
			//'To locate columns(cells) of that specific row'
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName('td'))

			//'To calculate no of columns(cells) In that specific row'
			int columns_count = Columns_row.size()

			//'Loop will execute till the last cell of that specific row'
			for (int column = 0; column < columns_count; column++) {

				if(column == 0) {
					Columns_row.get(0).click()
				}
				if(column == 2) {
					pres_no = Columns_row.get(2).getText()
				}
			}
		}
		WebUI.scrollToElement(findTestObject('Object Repository/Point Of Sales/Prescription Sales/button_next'), 5)
	}
	
	@And("I select prescription data - manual")
	def I_select_prescription_data_manual() {
		WebUI.scrollToElement(findTestObject('Object Repository/Point Of Sales/Prescription Sales/button_add_copy_prescription'), 5)

		WebDriver driver = DriverFactory.getWebDriver()
		//'To locate table'
		WebElement Table = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[4]/div[2]/div[1]/table/tbody"))
		//'To locate rows of table it will Capture all the rows available in the table'
		List<WebElement> rows_table = Table.findElements(By.tagName('tr'))
		//'To calculate no of rows In table'

		def rows_count = rows_table.size()

		for (int row = 0; row < rows_count; row++) {
			//'To locate columns(cells) of that specific row'
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName('td'))

			//'To calculate no of columns(cells) In that specific row'
			int columns_count = Columns_row.size()

			//'Loop will execute till the last cell of that specific row'
			for (int column = 0; column < columns_count; column++) {

				if(row == 0 && column == 0) {
					Columns_row.get(0).click()
				}
			}
		}
		WebUI.scrollToElement(findTestObject('Object Repository/Point Of Sales/Prescription Sales/button_next'), 5)
	}

	@And("I add prescription detail")
	def I_add_prescription_detail() {
		WebUI.scrollToElement(findTestObject('Object Repository/Point Of Sales/Prescription Sales/h4_Prescription Detail'), 5)

		WebDriver driver = DriverFactory.getWebDriver()
		//'To locate table'
		WebElement Table = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[2]/div[4]/div[1]/div[2]/table/tbody"))
		//'To locate rows of table it will Capture all the rows available in the table'
		List<WebElement> rows_table = Table.findElements(By.tagName('tr'))
		//'To calculate no of rows In table'

		def rows_count = rows_table.size()

		for (int row = 0; row < rows_count; row++) {
			//'To locate columns(cells) of that specific row'
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName('td'))

			//'To calculate no of columns(cells) In that specific row'
			int columns_count = Columns_row.size()

			//'Loop will execute till the last cell of that specific row'
			for (int column = 0; column < columns_count; column++) {

				if(column == 0) {
					Columns_row.get(0).click()
				}
			}
		}

		WebUI.scrollToPosition(999, 1050)
		//WebUI.scrollToElement(findTestObject('Object Repository/Point Of Sales/Prescription Sales/button_add'), 5)
		WebUI.click(findTestObject('Object Repository/Point Of Sales/Prescription Sales/button_add'))
		WebUI.scrollToPosition(999, 1200)
		
		WebElement Table2 = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div[4]/div[3]/div[2]/table/tbody"))
		//'To locate rows of table it will Capture all the rows available in the table'
		List<WebElement> rows_table2 = Table2.findElements(By.tagName('tr'))
		//'To calculate no of rows In table'

		def rows_count2 = rows_table2.size()

		for (int row = 0; row < rows_count2; row++) {
			//'To locate columns(cells) of that specific row'
			List<WebElement> Columns_row2 = rows_table2.get(row).findElements(By.tagName('td'))

			//'To calculate no of columns(cells) In that specific row'
			int columns_count2 = Columns_row2.size()

			//'Loop will execute till the last cell of that specific row'
			for (int column = 0; column < columns_count2; column++) {

				if(column == 7) {
					String price = Columns_row2.get(7).getText()
					price = price.substring(0, price.length()-3);
					println(price)
					BigDecimal harga=new BigDecimal(price);
					totalPrice = totalPrice + harga
				}
				if(column == 8) {
					String diskon = Columns_row2.get(8).getText()
					diskon = diskon.substring(0, diskon.length()-3);
					println(diskon)
					BigDecimal hargaDiskon=new BigDecimal(diskon);
					hargaTotalDiskon = hargaTotalDiskon + hargaDiskon
				}
			}
		}
	}
	
	@And("I add prescription special detail")
	def I_add_prescription_special_detail() {
		WebUI.scrollToElement(findTestObject('Object Repository/Point Of Sales/Prescription Sales/h4_Prescription Detail'), 5)

		WebDriver driver = DriverFactory.getWebDriver()
		//'To locate table'
		WebElement Table = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[2]/div[4]/div[1]/div[2]/table/tbody"))
		//'To locate rows of table it will Capture all the rows available in the table'
		List<WebElement> rows_table = Table.findElements(By.tagName('tr'))
		//'To calculate no of rows In table'

		def rows_count = rows_table.size()

		for (int row = 0; row < rows_count; row++) {
			//'To locate columns(cells) of that specific row'
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName('td'))

			//'To calculate no of columns(cells) In that specific row'
			int columns_count = Columns_row.size()

			//'Loop will execute till the last cell of that specific row'
			for (int column = 0; column < columns_count; column++) {

				if(column == 0) {
					Columns_row.get(0).click()
				}
			}
		}

		WebUI.scrollToPosition(999, 1050)
		//WebUI.scrollToElement(findTestObject('Object Repository/Point Of Sales/Prescription Sales/button_add'), 5)
		WebUI.click(findTestObject('Object Repository/Point Of Sales/Prescription Sales/button_add'))
		WebUI.delay(2)
		WebUI.scrollToPosition(999, 1300)
		
		WebElement Table2 = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div[4]/div[3]/div[2]/table/tbody"))
		//'To locate rows of table it will Capture all the rows available in the table'
		List<WebElement> rows_table2 = Table2.findElements(By.tagName('tr'))
		//'To calculate no of rows In table'

		def rows_count2 = rows_table2.size()

		for (int row = 0; row < rows_count2; row++) {
			//'To locate columns(cells) of that specific row'
			List<WebElement> Columns_row2 = rows_table2.get(row).findElements(By.tagName('td'))

			//'To calculate no of columns(cells) In that specific row'
			int columns_count2 = Columns_row2.size()

			//'Loop will execute till the last cell of that specific row'
			for (int column = 0; column < columns_count2; column++) {

				if(column == 6) {
					String price = Columns_row2.get(6).getText()
					price = price.substring(0, price.length()-3);
					println(price)
					BigDecimal harga=new BigDecimal(price);
					totalPrice = totalPrice + harga
				}
				if(column == 7) {
					String diskon = Columns_row2.get(7).getText()
					diskon = diskon.substring(0, diskon.length()-3);
					println(diskon)
					BigDecimal hargaDiskon=new BigDecimal(diskon);
					hargaTotalDiskon = hargaTotalDiskon + hargaDiskon
				}
			}
		}
	}
	
	@And("I add prescription manual detail")
	def I_add_prescription_manual_detail() {
		WebUI.scrollToElement(findTestObject('Object Repository/Point Of Sales/Prescription Sales/h4_Prescription Detail'), 5)

		WebDriver driver = DriverFactory.getWebDriver()
		//'To locate table'
		WebElement Table = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[2]/div[4]/div[1]/div[2]/table/tbody"))
		//'To locate rows of table it will Capture all the rows available in the table'
		List<WebElement> rows_table = Table.findElements(By.tagName('tr'))
		//'To calculate no of rows In table'

		def rows_count = rows_table.size()

		for (int row = 0; row < rows_count; row++) {
			//'To locate columns(cells) of that specific row'
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName('td'))

			//'To calculate no of columns(cells) In that specific row'
			int columns_count = Columns_row.size()

			//'Loop will execute till the last cell of that specific row'
			for (int column = 0; column < columns_count; column++) {

				if(column == 0) {
					Columns_row.get(0).click()
				}
			}
		}

		WebUI.scrollToPosition(999, 1050)
		//WebUI.scrollToElement(findTestObject('Object Repository/Point Of Sales/Prescription Sales/button_add'), 5)
		WebUI.click(findTestObject('Object Repository/Point Of Sales/Prescription Sales/button_add'))
		WebUI.delay(2)
		WebUI.scrollToPosition(999, 1300)
		
		WebElement Table2 = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div[4]/div[3]/div[2]/table/tbody"))
		//'To locate rows of table it will Capture all the rows available in the table'
		List<WebElement> rows_table2 = Table2.findElements(By.tagName('tr'))
		//'To calculate no of rows In table'

		def rows_count2 = rows_table2.size()

		for (int row = 0; row < rows_count2; row++) {
			//'To locate columns(cells) of that specific row'
			List<WebElement> Columns_row2 = rows_table2.get(row).findElements(By.tagName('td'))

			//'To calculate no of columns(cells) In that specific row'
			int columns_count2 = Columns_row2.size()

			//'Loop will execute till the last cell of that specific row'
			for (int column = 0; column < columns_count2; column++) {

				if(column == 7) {
					String price = Columns_row2.get(7).getText()
					price = price.substring(0, price.length()-3);
					println(price)
					BigDecimal harga=new BigDecimal(price);
					totalPrice = totalPrice + harga
				}
				if(column == 8) {
					String diskon = Columns_row2.get(8).getText()
					diskon = diskon.substring(0, diskon.length()-3);
					println(diskon)
					BigDecimal hargaDiskon=new BigDecimal(diskon);
					hargaTotalDiskon = hargaTotalDiskon + hargaDiskon
				}
			}
		}
	}

	@And("I verify prescription sales data")
	def I_verify_prescription_sales_data() {
		WebUI.scrollToElement(findTestObject('Object Repository/Point Of Sales/Prescription Sales/h4_Sales Info'), 5)
		String gross = WebUI.getText(findTestObject('Object Repository/Point Of Sales/Prescription Sales/label_gross'))
		String discount = WebUI.getText(findTestObject('Object Repository/Point Of Sales/Prescription Sales/label_discount'))
		String ppn = WebUI.getText(findTestObject('Object Repository/Point Of Sales/Prescription Sales/label_ppn'))
		String label_total_net_amount = WebUI.getText(findTestObject('Object Repository/Point Of Sales/Prescription Sales/label_total_net_amount'))
		String totalItem = WebUI.getText(findTestObject('Object Repository/Point Of Sales/Prescription Sales/label_total_item'))

		String grossPrice = gross.substring(0, gross.length()-3);
		BigDecimal hargaGross=new BigDecimal(grossPrice);

		String discountPrice = discount.substring(0, discount.length()-3);
		BigDecimal hargaDiscount=new BigDecimal(discountPrice);

		String ppnPrice = ppn.substring(0, ppn.length()-3);
		BigDecimal hargaPpn=new BigDecimal(ppnPrice);

		totalAmount = (hargaGross - hargaDiscount) + hargaPpn

		println(totalPrice)
		println(gross)
		println(label_total_net_amount)
		println(totalAmount)
		WebUI.verifyMatch(gross, totalPrice.toString()+',00', true)
		WebUI.verifyMatch(discount, hargaTotalDiskon.toString()+',00', true)
		WebUI.verifyMatch(ppn, '0,00', true)
		WebUI.verifyMatch(label_total_net_amount, totalAmount+',00', true)
		
	}
	
	@And("I add additional product")
	def I_add_additional_product() {
		WebUI.scrollToElement(findTestObject('Object Repository/Point Of Sales/Prescription Sales/div_Additional Product'), 5)
		WebUI.click(findTestObject('Object Repository/Point Of Sales/Prescription Sales/button_add'))
		
		WebUI.setText(findTestObject('Object Repository/Point Of Sales/Prescription Sales/Produk Service/textbox_product_service'), directsales.getValue('Product_service_name', 1))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Point Of Sales/Prescription Sales/Produk Service/button_search'))
		WebUI.click(findTestObject('Object Repository/Point Of Sales/Prescription Sales/Produk Service/button_Select'))
		
		//WebUI.focus(findTestObject('Object Repository/Point Of Sales/Prescription Sales/Ìnventory Item/textbox_inventory_item'))
		//WebUI.setText(findTestObject('Object Repository/Point Of Sales/Prescription Sales/Ìnventory Item/textbox_inventory_item'), directsales.getValue('Inventory_item_name', 1))
		//WebUI.click(findTestObject('Object Repository/Point Of Sales/Prescription Sales/Ìnventory Item/button_search'))
		//WebUI.click(findTestObject('Object Repository/Point Of Sales/Prescription Sales/Ìnventory Item/button_Select'))
		
		WebUI.click(findTestObject('Object Repository/Point Of Sales/Prescription Sales/button_Save'))
		
		WebDriver driver = DriverFactory.getWebDriver()
		//'To locate table'
		WebElement Table = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[2]/div[5]/div[2]/div[2]/div/table/tbody"))
		//'To locate rows of table it will Capture all the rows available in the table'
		List<WebElement> rows_table = Table.findElements(By.tagName('tr'))
		//'To calculate no of rows In table'

		def rows_count = rows_table.size()

		for (int row = 0; row < rows_count; row++) {
			//'To locate columns(cells) of that specific row'
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName('td'))

			//'To calculate no of columns(cells) In that specific row'
			int columns_count = Columns_row.size()

			//'Loop will execute till the last cell of that specific row'
			for (int column = 0; column < columns_count; column++) {

				if(column == 7) {
					String price = Columns_row.get(7).getText()
					price = price.substring(0, price.length()-3);
					println(price)
					BigDecimal harga=new BigDecimal(price);
					totalPrice = totalPrice + harga
				}
				if(column == 8) {
					String diskon = Columns_row.get(8).getText()
					diskon = diskon.substring(0, diskon.length()-3);
					println(diskon)
					BigDecimal hargaDiskon=new BigDecimal(diskon);
					hargaTotalDiskon = hargaTotalDiskon + hargaDiskon
				}
			}
		}
	}
	
	@And("I re-verify prescription sales data")
	def I_reverify_prescription_sales_data() {
		WebUI.scrollToElement(findTestObject('Object Repository/Point Of Sales/Prescription Sales/h4_Sales Info'), 5)
		String gross = WebUI.getText(findTestObject('Object Repository/Point Of Sales/Prescription Sales/label_gross2'))
		String discount = WebUI.getText(findTestObject('Object Repository/Point Of Sales/Prescription Sales/label_discount2'))
		String ppn = WebUI.getText(findTestObject('Object Repository/Point Of Sales/Prescription Sales/label_ppn2'))
		String label_total_net_amount = WebUI.getText(findTestObject('Object Repository/Point Of Sales/Prescription Sales/label_total_net_amount2'))
		String totalItem = WebUI.getText(findTestObject('Object Repository/Point Of Sales/Prescription Sales/label_total_item2'))

		String grossPrice = gross.substring(0, gross.length()-3);
		BigDecimal hargaGross=new BigDecimal(grossPrice);

		String discountPrice = discount.substring(0, discount.length()-3);
		BigDecimal hargaDiscount=new BigDecimal(discountPrice);

		String ppnPrice = ppn.substring(0, ppn.length()-3);
		BigDecimal hargaPpn=new BigDecimal(ppnPrice);

		totalAmount = (hargaGross - hargaDiscount) + hargaPpn

		println(totalPrice)
		println(gross)
		println(label_total_net_amount)
		println(totalAmount)
		WebUI.verifyMatch(gross, totalPrice.toString()+',00', true)
		WebUI.verifyMatch(discount, hargaTotalDiskon.toString()+',00', true)
		WebUI.verifyMatch(ppn, '0,00', true)
		WebUI.verifyMatch(label_total_net_amount, totalAmount+',00', true)
		
	}
	
	@And("I input prescription payment info")
	def I_input_prescription_payment_info() {
		WebUI.scrollToElement(findTestObject('Object Repository/Point Of Sales/Prescription Sales/Payment Info/h4_Payment Info'),5)
		
		WebUI.click(findTestObject('Object Repository/Point Of Sales/Prescription Sales/Payment Info/dropdown_payment_method'))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+directsales.getValue('Payment_method', 1)+"' or . = '"+directsales.getValue('Payment_method', 1)+"')]"))

		WebUI.click(findTestObject('Object Repository/Point Of Sales/Prescription Sales/Payment Info/dropdown_payment_channel'))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+directsales.getValue('Payment_channel', 1)+"' or . = '"+directsales.getValue('Payment_channel', 1)+"')]"))

		WebUI.setText(findTestObject('Object Repository/Point Of Sales/Prescription Sales/Payment Info/textbox_card_no'), directsales.getValue('Card_number', 1))

		WebUI.setText(findTestObject('Object Repository/Point Of Sales/Prescription Sales/Payment Info/textbox_reff_no'), directsales.getValue('Transaction_reff_no', 1))

		def paymentprice = WebUI.getAttribute(findTestObject('Object Repository/Point Of Sales/Prescription Sales/Payment Info/label_payment_amount'), 'value')

		WebUI.verifyMatch(paymentprice, totalAmount.toString()+',00' , true)
		
		WebUI.delay(2)

		WebUI.click(findTestObject('Object Repository/Point Of Sales/Prescription Sales/Payment Info/button_Paid'))

	}
	
	@And("I select other prescription")
	def I_select_other_prescription() {
		WebUI.scrollToElement(findTestObject('Object Repository/Point Of Sales/Prescription Sales/Prescription Info/h4_Prescription Info'), 5)
		WebUI.click(findTestObject('Object Repository/Point Of Sales/Prescription Sales/Prescription Info/dropdown_prescription_no'))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+pres_no+"' or . = '"+pres_no+"')]"))
	}
	
	@And("I click add copy prescription")
	def I_click_add_copy_prescription() {
		WebUI.scrollToElement(findTestObject('Object Repository/Point Of Sales/Prescription Sales/Prescription Info/h4_Prescription Info'), 5)
		WebUI.click(findTestObject('Object Repository/Point Of Sales/Prescription Sales/button_add_copy_prescription'))
	}
	
	@And("I click delete prescription")
	def I_click_delete_prescription() {
		WebUI.scrollToElement(findTestObject('Object Repository/Point Of Sales/Prescription Sales/Prescription Info/h4_Prescription Info'), 5)
		WebUI.click(findTestObject('Object Repository/Point Of Sales/Prescription Sales/button_delete'))
	}
	
	@And("I input copy prescription form")
	def I_input_copy_prescription_form() {
		WebUI.click(findTestObject('Object Repository/Point Of Sales/Prescription Sales/Copy Prescription/textbox_product_name'))
		WebUI.setText(findTestObject('Object Repository/Point Of Sales/Prescription Sales/Copy Prescription/textbox_product_search'), directsales.getValue('Product_service_name', 1))
		WebUI.click(findTestObject('Object Repository/Point Of Sales/Prescription Sales/Copy Prescription/button_search'))
		WebUI.click(findTestObject('Object Repository/Point Of Sales/Prescription Sales/Copy Prescription/button_add_product'))
		WebUI.delay(2)
		WebUI.setText(findTestObject('Object Repository/Point Of Sales/Prescription Sales/Copy Prescription/textbox_unit'), 1.toString())
		WebUI.click(findTestObject('Object Repository/Point Of Sales/Prescription Sales/Copy Prescription/dropdown_doctor'))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = 'AutoDok' or . = 'AutoDok')]"))
		WebUI.setText(findTestObject('Object Repository/Point Of Sales/Prescription Sales/Copy Prescription/textbox_signa'), 'Tes')
		WebUI.setText(findTestObject('Object Repository/Point Of Sales/Prescription Sales/Copy Prescription/textbox_iter'), 1.toString())
		WebUI.click(findTestObject('Object Repository/Point Of Sales/Prescription Sales/Copy Prescription/button_Add'))
		WebUI.click(findTestObject('Object Repository/Point Of Sales/Prescription Sales/Copy Prescription/button_Save'))
		WebUI.delay(10)
	}

	@When("I open prescription sales detail")
	def I_open_prescription_sales_detail() {
		WebUI.scrollToPosition(999, 100)
		WebUI.click(findTestObject('Object Repository/Point Of Sales/Prescription Sales/button_select'))
	}

	@Then("Prescription Sales data successfully submitted")
	def Prescription_sales_data_successfully_submitted() {
		def text = WebUI.getText(findTestObject('Object Repository/Point Of Sales/Prescription Sales/div_Submit_data_payment_success'))
		//WebUI.verifyMatch(text, 'Submit data payment success!', false)
		WebUI.delay(2)
	}
	
	@Then("Prescription Sales data successfully deleted")
	def Prescription_sales_data_successfully_deleted() {
		def text = WebUI.getText(findTestObject('Object Repository/Point Of Sales/Prescription Sales/div_delete_selected_data_success'))
		//WebUI.verifyMatch(text, 'Submit data payment success!', false)
		WebUI.delay(2)
	}
}