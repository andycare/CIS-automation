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

CucumberKW.runFeatureFileWithTags('Include/features/login/Login.feature', '@loginFO')

WebUI.click(findTestObject('FO/Patient/Patient Data/a_frontoffice'))

WebUI.click(findTestObject('Object Repository/Menu/Module/Frontline'))

WebUI.click(findTestObject('Object Repository/Menu/Sub Module/Appointment'))

WebUI.click(findTestObject('Object Repository/FO/Appointment/btn_Add'))

WebUI.setText(findTestObject('FO/Appointment/textbox_Patient'), findTestData('Patient/Patient_data').getValue(1, 4))

WebUI.click(findTestObject('FO/Appointment/btn_SearchPatient'))

WebUI.click(findTestObject('FO/Appointment/button_SelectPatient'))

WebUI.delay(3)

WebUI.verifyTextPresent(findTestData('Patient/Patient_data').getValue(12, 4), true, FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('FO/Appointment/btn_BackStp2'), 5)

WebUI.click(findTestObject('FO/Appointment/dropdown_ServiceActivity'))

WebUI.click(findTestObject('FO/Appointment/list_Consultation'))

WebUI.click(findTestObject('FO/Appointment/dropdown_Doctor'))

WebUI.click(findTestObject('FO/Appointment/list_drAnjar'))

not_run: WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//span[(text() = \'Select a Treatment\' or . = \'Select a Treatment\')]'))

not_run: WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//li[(text() = \'Double Basic DPCT (Medical Grade Facial)\' or . = \'Double Basic DPCT (Medical Grade Facial)\')]'))

//new Datepicker().pickDate(new TestObject().addProperty('xpath', ConditionType.EQUALS, "(//input[@type='text'])[6]"), '12/04/2023')
//def todaysdate = new Date().format('MM/DD/YYYY')
//new Datepicker().pickDate(new TestObject().addProperty('xpath', ConditionType.EQUALS, '(//input[@type=\'text\'])[6]'), todaysdate)
not_run: WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//div[@id=\'root\']/div/div/div[2]/div[2]/form/div/div[2]/div[2]/div/div/div[2]/div/div/div/span'))

CustomKeywords.'customkeyword.Datepicker.pickDate'(findTestObject('FO/Appointment/Datepicker/Datepicker'), '12/06/2023')

WebUI.click(findTestObject('FO/Appointment/dropdown_AppointmentTime'))

WebUI.click(findTestObject('FO/Appointment/list_room'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('FO/Appointment/textarea__DescriptionAPP'), 'Auto88')

WebUI.click(findTestObject('FO/Appointment/button_NextStp2'))

WebUI.scrollToElement(findTestObject('Object Repository/FO/Appointment/label_AppointmentInfo'), 5)

//Verrify appointment data
def branch = WebUI.getText(findTestObject('Object Repository/FO/Appointment/label_branch'))

def service_activity = WebUI.getText(findTestObject('Object Repository/FO/Appointment/Label_serviceActivity'))

def doctor = WebUI.getText(findTestObject('Object Repository/FO/Appointment/label_doctor'))

def treatment = WebUI.getText(findTestObject('Object Repository/FO/Appointment/label_treatment'))

def tanggal = WebUI.getText(findTestObject('Object Repository/FO/Appointment/label_date'))

def waktu = WebUI.getText(findTestObject('Object Repository/FO/Appointment/label_time'))

not_run: Date date = new Date('12/06/2023')

not_run: def formatedDate = date.format('dd MMM yyyy')

not_run: String str = 'Ruang Reguler Treatment 1 - Bed 1 : 10:00:00 - 10:30:00'

WebUI.verifyMatch(branch, 'Klinik Utama Erha Ultimate BSD', true)

WebUI.verifyMatch(service_activity, 'Consultation', true)

WebUI.verifyMatch(doctor, '-', true)

not_run: WebUI.verifyMatch(treatment, 'Double Basic DPCT \\(Medical Grade Facial\\)', true)

not_run: WebUI.verifyMatch(tanggal, formatedDate, true, FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.verifyMatch(waktu, str.substring(36, 44), true, FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('Object Repository/FO/Appointment/btn_post'), 5)

WebUI.click(findTestObject('Object Repository/FO/Appointment/btn_post'))

