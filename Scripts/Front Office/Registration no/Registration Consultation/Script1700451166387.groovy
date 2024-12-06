import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By
import com.kms.katalon.core.webui.driver.DriverFactory

def registrationNo
def queuingNo
def patient = findTestData("Patient/Patient_data")
def registration = findTestData("Registration/registration_data")

CucumberKW.runFeatureFileWithTags('Include/features/login/Login.feature', '@loginFO')

WebUI.click(findTestObject('FO/Patient/Patient Data/a_frontoffice'))

WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//a[@href = '#/dashboard' and (text() = 'Frontline' or . = 'Frontline')]"))

WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//a[@href = '#/registration' and (text() = 'Registration' or . = 'Registration')]"))

WebUI.click(findTestObject('Object Repository/FO/Registration/btn_add'))

WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='dropdown']/span"))

WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = 'Patient Phone' or . = 'Patient Phone')]"))

WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@placeholder = 'Patient Name / Birthdate / Phone No.']"), patient.getValue('no_hp', 1))

WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[(text() = ' ' or . = ' ')]"))

WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[(text() = 'Select' or . = 'Select')]"))
		
def patientname = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/form/div[2]/div/div/div[4]"))
def phoneno = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/form/div[2]/div[2]/div/div[2]"))
def email = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='root']/div/div/div[2]/div[2]/form/div[2]/div[2]/div/div[4]"))
def fullname = WebUI.concatenate([
	patient.getValue('Patient_First_Name', 1),
	' ',
	patient.getValue('Patient_Middle_Name', 1),
	' ',
	patient.getValue('Patient_Last_Name', 1)] as String[])
WebUI.verifyMatch(patientname, fullname, true)
WebUI.verifyMatch(phoneno, patient.getValue('no_hp', 1), true)
WebUI.verifyMatch(email, patient.getValue('email', 1), true)

WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/label_RegistrationInfo'), 5)

WebUI.setText(findTestObject('Object Repository/FO/Registration/textarea_note'), registration.getValue('note', 1))

WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[(text() = 'Next' or . = 'Next')]"))

WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/label_RegistrationInfo'), 5)

WebUI.click(findTestObject('Object Repository/FO/Registration/btn_add'))

WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/btn_add'), 5)

WebUI.click(findTestObject('null'))

WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+registration.getValue('Service_activity', 1)+"' or . = '"+registration.getValue('Service_activity', 1)+"')]"))

WebUI.click(findTestObject('null'))

WebUI.focus(findTestObject('null'))

WebUI.setText(findTestObject('null'), registration.getValue('Doctor', 1))

WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+registration.getValue('Doctor', 1)+"' or . = '"+registration.getValue('Doctor', 1)+"')]"))

WebUI.click(findTestObject('null'))

WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+registration.getValue('Product_service', 1)+"' or . = '"+registration.getValue('Product_service', 1)+"')]"))

WebUI.click(findTestObject('null'))

WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//li[(text() = '"+registration.getValue('Room_schedule', 1)+"' or . = '"+registration.getValue('Room_schedule', 1)+"')]"))

WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/btn_save'), 5)

WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/btn_add'), 5)

WebUI.click(findTestObject('Object Repository/FO/Registration/btn_save'))

WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h2[@id = 'swal2-title' and (text() = 'Your record has been saved' or . = 'Your record has been saved')]"), 10)
def text = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h2[@id = 'swal2-title' and (text() = 'Your record has been saved' or . = 'Your record has been saved')]"))
WebUI.verifyMatch(text, 'Your record has been saved', true)

WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[(text() = 'Next' or . = 'Next')]"), 5)

WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//button[(text() = 'Next' or . = 'Next')]"))

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
			WebUI.verifyMatch(celltext, 'Ultimate Acne Cure \\- Acne Finale \\- Acne Scar Program', true)
		}
	}
}

WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/label_registrationFeeInfo'), 5)

WebUI.click(findTestObject('Object Repository/FO/Registration/btn_post'))

WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id = 'swal2-html-container' and (text() = 'Record has been created.' or . = 'Record has been created.')]"), 10)
def text2 = WebUI.getText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id = 'swal2-html-container' and (text() = 'Record has been created.' or . = 'Record has been created.')]"))
WebUI.verifyMatch(text2, 'Record has been created.', true)

WebUI.scrollToElement(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//h4[(text() = 'Registration Info' or . = 'Registration Info')]"), 5)

def regisStatus = WebUI.getText(findTestObject('Object Repository/FO/Appointment/label_registrationStatus'))
WebUI.verifyMatch(regisStatus, 'Waiting', true)

queuingNo = WebUI.getText(findTestObject('Object Repository/FO/Appointment/label_queuingNo'))
GlobalVariable.queuingNo = WebUI.getText(findTestObject('Object Repository/FO/Appointment/label_queuingNo'))
println(queuingNo)

WebUI.scrollToElement(findTestObject('Object Repository/FO/Registration/btn_back'), 5)

WebUI.click(findTestObject('Object Repository/FO/Registration/btn_back'))