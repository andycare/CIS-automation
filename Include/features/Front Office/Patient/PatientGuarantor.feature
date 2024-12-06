#Author: your.email@your.domain.com

@DeletePatient
Feature: Delete Patient Feature
  
  Background: User is Logged In and open patient page
	Given I already login as FO
	When I already open FO page
	
		@AddGuarantor
	Scenario: Edit Patient - Add new patient Guarantor from Guarantor form
		Given I am open patient page
		And I search patient data
		And I open patient detail page
		When I click tab guarantor
		And I click add guarantor
		And i input all guarantor field
		And I click save guarantor
		Then guarantor succesfully added
		
		@EditPatientGuarantor
		Scenario: Edit Patient - Edit patient guarantor
		Given I am open patient page
		And I search patient data
		And I open patient detail page
		When I click tab guarantor
		And I select guarantor
		And I edit guarantor data
		And I click save guarantor
    Then Guarantor succesfully updated
		
		@DeleteGuarantor
		Scenario: Edit Patient - Delete patient Guarantor
		Given I am open patient page
		And I search patient data
		And I open patient detail page
		When I click tab guarantor
		And I Choose guarantor
		And I click delete
		And I click yes
		Then guarantor succesfully deleted
		