
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import com.kms.katalon.core.testobject.TestObject

import java.lang.String

import com.kms.katalon.core.model.FailureHandling



def static "customkeyword.uploadFileKey.uploadFile"(
    	TestObject to	
     , 	String filePath	) {
    (new customkeyword.uploadFileKey()).uploadFile(
        	to
         , 	filePath)
}


def static "customkeyword.DatepickerPatient.pickDate"(
    	TestObject ob	
     , 	String date	) {
    (new customkeyword.DatepickerPatient()).pickDate(
        	ob
         , 	date)
}


def static "customkeyword.click.clickUsingJS"(
    	TestObject to	) {
    (new customkeyword.click()).clickUsingJS(
        	to)
}


def static "customkeyword.Datepicker.pickDate"(
    	TestObject ob	
     , 	String date	) {
    (new customkeyword.Datepicker()).pickDate(
        	ob
         , 	date)
}


def static "com.katalon.plugin.keyword.calendar.SetDateCalendarKeyword.setDate"(
    	TestObject to	
     , 	int day	
     , 	int month	
     , 	int year	
     , 	int slideTimeOut	
     , 	FailureHandling flowControl	) {
    (new com.katalon.plugin.keyword.calendar.SetDateCalendarKeyword()).setDate(
        	to
         , 	day
         , 	month
         , 	year
         , 	slideTimeOut
         , 	flowControl)
}
