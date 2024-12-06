package pos

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
import groovy.ui.SystemOutputInterceptor

import com.kms.katalon.core.main.CustomKeywordDelegatingMetaClass

import org.openqa.selenium.Keys as Keys


class DirectSales {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */

	def patient = findTestData("Patient/Patient_data")
	def patient_address = findTestData("Patient/Patient_address")
	def directsales = findTestData("Direct Sales/DirectSales")
	def actualtotalprice
	def totalsalesinfo
	def productprice1
	def productprice2
	def discount1
	def discount2
	BigDecimal total


	@Given("I am open direct sales page")
	def I_am_open_direct_sales_page() {
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//a[@href = '#/dashboard' and (text() = 'Point of Sales' or . = 'Point of Sales')]"))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//a[@href = '#/direct-sales' and (text() = 'Direct Sales' or . = 'Direct Sales')]"))
	}

	@And("I input sales info data1")
	def I_input_sales_info_data1() {
		WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h4[(text() = 'Sales Info' or . = 'Sales Info')]"), 5)

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "(//button[@type='button'])[6]"))

		WebUI.delay(2)

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[@type = 'button' and (text() = 'Add Membership' or . = 'Add Membership')]"))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='membership_id']/span"))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = 'MEGA IFINITE10' or . = 'MEGA IFINITE10')]"))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='pr_id_11_content']/div/div/table/tbody/tr/td[3]/div/button"))

		WebUI.delay(2)

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='pr_id_11_content']/div/div/table/tbody/tr/td[3]/button"))

		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, "transaction_desc"), directsales.getValue('Sales_info_note', 1))
	}

	@And("I input sales info data2")
	def I_input_sales_info_data2() {
		WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h4[(text() = 'Sales Info' or . = 'Sales Info')]"), 5)

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "(//button[@type='button'])[6]"))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='pr_id_11_content']/div/div/table/tbody/tr/td[3]/button"))

		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, "transaction_desc"), directsales.getValue('Sales_info_note', 1))
	}

	@And("I input delivery info")
	def I_input_delivery_info() {
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='is_delivery']/span"))

		WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h4[(text() = 'Delivery Info' or . = 'Delivery Info')]"), 5)

		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, "receiver"), directsales.getValue('Receiver_name', 1))

		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, "receiver_address_1"), directsales.getValue('Receiver_address', 1))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[(text() = 'Search Address' or . = 'Search Address')]"))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[(text() = 'select' or . = 'select')]"))

		def phoneno = WebUI.getAttribute(new TestObject().addProperty('id', ConditionType.EQUALS, "receiver_phone_no"),'value')
		WebUI.verifyMatch(phoneno, '62'+patient_address.getValue('phone_no', 1), true)

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='delivery_service_id']/span"))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+directsales.getValue('Delivery_service', 1)+"' or . = '"+directsales.getValue('Delivery_service', 1)+"')]"))

		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, "delivery_fee"), directsales.getValue('Delivery_fee', 1))
	}

	@And("I input new delivery info")
	def I_input_new_delivery_info() {
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='is_delivery']/span"))

		WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h4[(text() = 'Delivery Info' or . = 'Delivery Info')]"), 5)

		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, "receiver"), directsales.getValue('Receiver_name', 1))

		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, "receiver_address_1"), directsales.getValue('Receiver_address', 1))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[(text() = 'Add Address' or . = 'Add Address')]"))

		//start input new address
		WebUI.enhancedClick(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='addressType']/span"))

		WebUI.enhancedClick(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+patient_address.getValue('address_type', 2)+"' or . = '"+patient_address.getValue('address_type', 2)+"')]"))

		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, "patientAddress_1"), patient_address.getValue('address', 2))

		WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='provinceId']/span"), 0)

		WebUI.enhancedClick(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='provinceId']/span"))

		WebUI.enhancedClick(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+patient_address.getValue('province', 2)+"' or . = '"+patient_address.getValue('province', 2)+"')]"))

		WebUI.enhancedClick(new TestObject().addProperty('xpath', ConditionType.EQUALS, "(//button[@type='button'])[10]"))

		WebUI.delay(2)

		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@type = 'text' and @id = 'searchParam']"), patient_address.getValue('district', 2))

		WebUI.enhancedClick(new TestObject().addProperty('id', ConditionType.EQUALS, "pr_id_22_content"))

		WebUI.enhancedClick(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[(text() = 'Select' or . = 'Select')]"))

		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, "rt"), patient_address.getValue('rt', 2))

		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, "rw"), patient_address.getValue('rw', 2))

		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, "phoneNo"), patient_address.getValue('phone_no', 2))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[@type = 'submit' and (text() = 'Save' or . = 'Save')]"))

		def phoneno = WebUI.getAttribute(new TestObject().addProperty('id', ConditionType.EQUALS, "receiver_phone_no"),'value')
		WebUI.verifyMatch(phoneno, '62'+patient_address.getValue('phone_no', 2), true)

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='delivery_service_id']/span"))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+directsales.getValue('Delivery_service', 1)+"' or . = '"+directsales.getValue('Delivery_service', 1)+"')]"))

		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, "delivery_fee"), directsales.getValue('Delivery_fee', 1))

	}

	@And("I click add product")
	def I_click_add_product() {
		WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[(text() = 'Product' or . = 'Product')]"), 5)

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[(text() = 'Add' or . = 'Add')]"))
	}

	@And("I add Product Service")
	def I_add_product_service() {
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='pr_id_14_content']/div/div/div/div[2]/div/input"), directsales.getValue('Product_service_name', 1))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='pr_id_14_content']/div/div/div/div[2]/div/button"))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='pr_id_14_content']/div/div/div/div[3]/div/div/div/table/tbody/tr/td[6]/div/button"))
	}

	@And("I add Inventory List")
	def I_add_inventory_list() {
		//WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='pr_id_14_content']/div/div[2]/div/div[2]/div/input"), directsales.getValue('Inventory_item_name', 1))

		//WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='pr_id_14_content']/div/div[2]/div/div[2]/div/button"))

		//WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='pr_id_14_content']/div/div[2]/div/div[3]/div/div/div/table/tbody/tr/td[6]/div/button"))
	}

	@And("I save product")
	def I_save_product() {
		WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[(text() = 'Save' or . = 'Save')]"), 5)

		def product = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='pr_id_14_content']/div/div[3]/div/div[2]/div/div/div/table/tbody/tr/td[4]"))

		//def inventoryList = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='pr_id_14_content']/div/div[3]/div/div[2]/div/div/div/table/tbody/tr[2]/td[4]"))

		//WebUI.verifyMatch(product, directsales.getValue('Product_service_name', 1), true)

		//WebUI.verifyMatch(inventoryList, directsales.getValue('Inventory_item_name', 1), true)

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[(text() = 'Save' or . = 'Save')]"))

		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id = 'swal2-html-container' and (text() = 'Update data success!' or . = 'Update data success!')]"), 10)
		def text = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id = 'swal2-html-container' and (text() = 'Update data success!' or . = 'Update data success!')]"))
		WebUI.verifyMatch(text, 'Update data success!', true)
	}

	@And("I validate product data")
	def I_validate_product_data() {
		//validate harga
		productprice1 = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div/div[4]/div[2]/div[2]/div/table/tbody/tr/td[8]"))
		//productprice2 = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div/div[4]/div[2]/div[2]/div/table/tbody/tr[2]/td[8]"))
		discount1 = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div/div[4]/div[2]/div[2]/div/table/tbody/tr/td[9]"))
		//discount2 = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div/div[5]/div/div/table/tbody/tr[2]/td[8]"))
		actualtotalprice = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div/div[4]/div[2]/div[3]/h5"))

		String str = productprice1.substring(0, productprice1.length()-3);
		BigDecimal product1=new BigDecimal(str);

		String diskon = discount1.substring(0, discount1.length()-3);
		BigDecimal disc1=new BigDecimal(diskon);

		total = (product1-disc1)

		WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h4[(text() = 'Sales Info' or . = 'Sales Info')]"), 5)

		totalsalesinfo = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div/div[3]/div/div/div/div[14]"))
		WebUI.verifyMatch(totalsalesinfo, 'IDR' +total.toString()+',00' , true)

		WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[(text() = 'Next' or . = 'Next')]"), 5)

	}

	@And("I validate product and delivery data")
	def I_validate_product_and_delivery_data() {
		//validate harga
		productprice1 = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div/div[5]/div[2]/div[2]/div/table/tbody/tr/td[8]"))
		//productprice2 = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div/div[4]/div[2]/div[2]/div/table/tbody/tr[2]/td[8]"))
		discount1 = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div/div[5]/div[2]/div[2]/div/table/tbody/tr/td[9]"))
		//discount2 = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div/div[5]/div/div/table/tbody/tr[2]/td[8]"))
		actualtotalprice = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div/div[5]/div[2]/div[2]/div/table/tbody/tr/td[9]"))

		WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h4[(text() = 'Delivery Info' or . = 'Delivery Info')]"), 5)
		def delivery = WebUI.getAttribute(new TestObject().addProperty('id', ConditionType.EQUALS, "delivery_fee"), 'value')

		String str = productprice1.substring(0, productprice1.length()-3);
		BigDecimal product1=new BigDecimal(str);

		String diskon = discount1.substring(0, discount1.length()-3);
		BigDecimal disc1=new BigDecimal(diskon);
		BigDecimal deliveryprice=new BigDecimal(delivery);

		total = (product1-disc1)+deliveryprice

		WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h4[(text() = 'Sales Info' or . = 'Sales Info')]"), 5)

		totalsalesinfo = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div/div[3]/div/div/div/div[14]"))
		WebUI.verifyMatch(totalsalesinfo, 'IDR' +total.toString()+',00' , true)

		WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[(text() = 'Next' or . = 'Next')]"), 5)

	}

	@And("I input payment info")
	def I_input_payment_info() {
		//WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[(text() = 'Product' or . = 'Product')]"), 5)

		WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[(text() = 'Back' or . = 'Back')]"), 5)

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='paymentMethod']/span"))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+directsales.getValue('Payment_method', 1)+"' or . = '"+directsales.getValue('Payment_method', 1)+"')]"))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='instanceName']/span"))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+directsales.getValue('Payment_channel', 1)+"' or . = '"+directsales.getValue('Payment_channel', 1)+"')]"))

		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, "cardNo"), directsales.getValue('Card_number', 1))

		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, "transactionReffNo"), directsales.getValue('Transaction_reff_no', 1))

		def paymentprice = WebUI.getAttribute(new TestObject().addProperty('id', ConditionType.EQUALS, "paymentAmount"), 'value')

		WebUI.verifyMatch(paymentprice, total.toString()+',00' , true)

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[(text() = 'Paid' or . = 'Paid')]"))

	}

	@And("Validate payment data is correct")
	def validate_payment_data_correct() {
		def paymentmethod = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div/div[6]/div/div/div/table/tbody/tr/td[2]"))
		def paymentchannel = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div/div[6]/div/div/div/table/tbody/tr/td[3]"))
		def cardno = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div/div[6]/div/div/div/table/tbody/tr/td[4]"))
		def TransRefNo = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div/div[6]/div/div/div/table/tbody/tr/td[5]"))
		def paymentamount = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div/div[6]/div/div/div/table/tbody/tr/td[6]"))

		WebUI.verifyMatch(paymentmethod, directsales.getValue('Payment_method', 1), true)
		WebUI.verifyMatch(paymentchannel, directsales.getValue('Payment_channel', 1), true)
		WebUI.verifyMatch(cardno, directsales.getValue('Card_number', 1), true)
		WebUI.verifyMatch(TransRefNo, directsales.getValue('Transaction_reff_no', 1), true)
		WebUI.verifyMatch(paymentamount, total.toString()+',00', true)

		WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h4[(text() = 'Sales Info' or . = 'Sales Info')]"), 5)

		def paymentstatus = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div/div[3]/div/div[2]/div/div[2]"))
		WebUI.verifyMatch(paymentstatus, directsales.getValue('Payment_status', 1), true)

		WebUI.closeBrowser()
	}

	@And("Validate payment & delivery data is correct")
	def validate_payment_and_delivery_data_correct() {
		def paymentmethod = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div/div[7]/div/div/div/table/tbody/tr/td[2]"))
		def paymentchannel = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div/div[7]/div/div/div/table/tbody/tr/td[3]"))
		def cardno = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div/div[7]/div/div/div/table/tbody/tr/td[4]"))
		def TransRefNo = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div/div[7]/div/div/div/table/tbody/tr/td[5]"))
		def paymentamount = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div/div[7]/div/div/div/table/tbody/tr/td[6]"))

		WebUI.verifyMatch(paymentmethod, directsales.getValue('Payment_method', 1), true)
		WebUI.verifyMatch(paymentchannel, directsales.getValue('Payment_channel', 1), true)
		WebUI.verifyMatch(cardno, directsales.getValue('Card_number', 1), true)
		WebUI.verifyMatch(TransRefNo, directsales.getValue('Transaction_reff_no', 1), true)
		WebUI.verifyMatch(paymentamount, total.toString()+',00', true)

		WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h4[(text() = 'Delivery Info' or . = 'Delivery Info')]"), 5)
		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, "delivery_reff_no"), directsales.getValue('Delivery_reff_no', 1))
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[@type = 'submit' and (text() = 'Save' or . = 'Save')]"))

		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id = 'swal2-html-container' and (text() = 'Update data success!' or . = 'Update data success!')]"), 10)
		def text = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id = 'swal2-html-container' and (text() = 'Update data success!' or . = 'Update data success!')]"))
		WebUI.verifyMatch(text, 'Update data success!', true)

		WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h4[(text() = 'Sales Info' or . = 'Sales Info')]"), 5)

		def paymentstatus = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div/div[3]/div/div[2]/div/div[2]"))
		WebUI.verifyMatch(paymentstatus, directsales.getValue('Payment_status', 1), true)

		WebUI.closeBrowser()
	}

	@And("I input direct sales patient data")
	def I_input_direct_sales_patient_data() {
		WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h4[(text() = 'Quick Patient Register' or . = 'Quick Patient Register')]"), 5)

		WebUI.click(findTestObject('Object Repository/Point Of Sales/Direct Sales/Patient/dropdown_salutation'))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+patient.getValue('Salutation', 2)+"' or . = '"+patient.getValue('Salutation', 2)+"')]"))

		WebUI.setText(findTestObject('Object Repository/Point Of Sales/Direct Sales/Patient/txt_patientFirstName'), patient.getValue('Patient_First_Name', 2))

		WebUI.setText(findTestObject('Object Repository/Point Of Sales/Direct Sales/Patient/txt_patientLastName'), patient.getValue('Patient_Last_Name', 2))

		WebUI.setText(findTestObject('Object Repository/Point Of Sales/Direct Sales/Patient/txt_patientPhoneNo'), patient.getValue('no_hp', 2))

		WebUI.click(findTestObject('Object Repository/Point Of Sales/Direct Sales/Patient/dropdown_gender'))

		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+patient.getValue('Gender', 2)+"' or . = '"+patient.getValue('Gender', 2)+"')]"))

		WebUI.focus(findTestObject('Object Repository/Point Of Sales/Direct Sales/Patient/txt_birthdate'))
		WebUI.delay(3)

		WebElement Tgl_Lahir = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Point Of Sales/Direct Sales/Patient/txt_birthdate'),10)

		WebUI.executeJavaScript("arguments[0].value='"+patient.getValue('Birthdate', 2)+"'", Arrays.asList(Tgl_Lahir))

		WebUI.focus(findTestObject('Object Repository/Point Of Sales/Direct Sales/Patient/txt_patientEmail'))

		WebUI.setText(findTestObject('Object Repository/Point Of Sales/Direct Sales/Patient/txt_patientEmail'), patient.getValue('email', 2))

		WebUI.click(findTestObject('Object Repository/Point Of Sales/Direct Sales/Patient/btn_save'))
	}

	@When("I open direct sales detail page")
	def I_open_direct_sales_detail_page() {
		def patientname = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div/div[2]/div/div/div[4]"))
		def phoneno = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div[2]"))
		def email = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div[4]"))
		def fullname = WebUI.concatenate([patient.getValue('Patient_First_Name', 1), ' ', patient.getValue('Patient_Middle_Name', 1), ' ', patient.getValue('Patient_Last_Name', 1), ' ', ' ', '(', patient.getValue('Gender', 1), ')'] as String[])
		//WebUI.verifyMatch(patientname, fullname, true)
		WebUI.verifyMatch(phoneno, patient.getValue('no_hp', 1), true)
		WebUI.verifyMatch(email, patient.getValue('email', 1), true)
	}

	@When("I open new direct sales detail page")
	def I_open_new_direct_sales_detail_page() {
		def patientname = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div/div[2]/div/div/div[4]"))
		def phoneno = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div[2]"))
		def email = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div[4]"))
		def fullname = WebUI.concatenate([patient.getValue('Patient_First_Name', 2), ' ', patient.getValue('Patient_Last_Name', 2), ' ', ' ', '(', patient.getValue('Gender', 2), ')'] as String[])
		//WebUI.verifyMatch(patientname, fullname, true)
		WebUI.verifyMatch(phoneno, patient.getValue('no_hp', 2), true)
		WebUI.verifyMatch(email, patient.getValue('email', 2), true)
	}

	@Then("Direct Sales data successfully created")
	def Direct_Sales_data_successfully_created() {
		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id = 'swal2-html-container' and (text() = 'Submit data payment success!' or . = 'Submit data payment success!')]"), 10)
		def text = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id = 'swal2-html-container' and (text() = 'Submit data payment success!' or . = 'Submit data payment success!')]"))
		WebUI.verifyMatch(text, 'Submit data payment success!', true)
		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[(text() = 'Refresh' or . = 'Refresh')]"),5)
		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[(text() = 'Recall' or . = 'Recall')]"),5)
	}
}