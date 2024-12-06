#Author: your.email@your.domain.com

@PatientDocument
Feature: Patient Feature
  
  Background: User is Logged In and open patient page
	Given I already login as FO
	When I already open FO page
		
		@AddDocument
  Scenario: Edit Patient - Add new patient Document from Document form
  	Given I am open patient page
		And I search patient data
		And I open patient detail page
		When I click tab document
		And I click add document
		And i input all document field
		And I click save document
		Then document succesfully added
		
		@EditPatientDocument
		Scenario: Edit Patient - Edit patient document
		Given I am open patient page
		And I search patient data
		And I open patient detail page
		When I click tab document
		And I select document
		And I edit document data
		And I click save document
    Then Document succesfully updated
    
    @DeleteDocument
		Scenario: Edit Patient - Delete patient Document
		Given I am open patient page
		And I search patient data
		And I open patient detail page
		When I click tab document
		And I Choose document
		And I click delete
		And I click yes
		Then document succesfully deleted