package customkeyword

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

import static java.util.Calendar.*
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

public class DatepickerPatient {
	/**
	 * Refresh browser
	 */
	Date date;
	TestObject obj;

	DatepickerPatient() {}
	DatepickerPatient(TestObject object, String input_date) {
		this.obj = object;
		date = new Date().parse("MM/dd/yyyy", input_date)
		println(date)
	}

	def open_calendar_form() {
		WebUI.waitForElementClickable(this.obj, 5)
		WebUI.click(this.obj)
	}

	def displaying_month() {
		WebUI.waitForElementVisible(findTestObject('Object Repository/FO/Patient/Patient Guarantor/Datepicker/span_November'), 5)
		def month = WebUI.getText(
				findTestObject('Object Repository/FO/Patient/Patient Guarantor/Datepicker/span_November'),
				FailureHandling.STOP_ON_FAILURE)
		println(month)
		return month
	}

	def displaying_year() {
		WebUI.waitForElementVisible(findTestObject('Object Repository/FO/Patient/Patient Guarantor/Datepicker/span_2023'), 5)
		def year = WebUI.getText(
				findTestObject('Object Repository/FO/Patient/Patient Guarantor/Datepicker/span_2023'),
				FailureHandling.STOP_ON_FAILURE)
		println(year)
		return year
	}

	def displaying_date() {
		Date display_date = new Date().parse("MMM/yyyy", displaying_month() + "/" + displaying_year())
		println(display_date)
		return display_date
	}

	def pick_year() {
		if (displaying_date()[YEAR] == date[YEAR]) return
			while (displaying_date()[YEAR] < date[YEAR]) {
				WebUI.click(findTestObject('Object Repository/FO/Patient/Patient Guarantor/Datepicker/span_2023'))
				WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+date[YEAR].toString()+"' or . = '"+date[YEAR].toString()+"')]"))
			}
		while (displaying_date()[YEAR] > date[YEAR]) {
			WebUI.click(findTestObject('Object Repository/FO/Patient/Patient Guarantor/Datepicker/span_2023'))
			WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+date[YEAR].toString()+"' or . = '"+date[YEAR].toString()+"')]"))
		}
	}

	def pick_month() {
		if (displaying_date()[MONTH] == date[MONTH]) return
			while (displaying_date()[MONTH] < date[MONTH]) {
				WebUI.click(findTestObject('Object Repository/FO/Patient/Patient Guarantor/Datepicker/button_next'))
			}
		while (displaying_date()[MONTH] > date[MONTH]) {
			WebUI.click(findTestObject('Object Repository/FO/Patient/Patient Guarantor/Datepicker/button_prev'))
		}
	}

	def pick_day() {
		println date[DAY_OF_MONTH]
		def tanggal = WebUI.modifyObjectProperty(findTestObject('Object Repository/FO/Appointment/Datepicker/span_24'), 'text','equals', date[DAY_OF_MONTH].toString(), true)
		WebUI.click(tanggal)
	}

	def pick_date() {
		pick_year()
		pick_month()
		pick_day()
	}

	@Keyword
	def pickDate(TestObject ob, String date) {
		def picker = new DatepickerPatient(ob, date)
		picker.open_calendar_form()
		picker.pick_date()
	}
}
