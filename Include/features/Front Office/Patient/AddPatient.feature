#Author: your.email@your.domain.com

@AddPatient
Feature: Patient Feature

  Background: User is Logged In and open patient page
	Given I already login as FO
	When I already open FO page
	
  @AddPatientData
  Scenario: Add New Patient
    Given I am open patient page
    When I click add patient
    And I input all field
    And I click save patient
    Then Data succesfully added
    
    @CheckMandatory
    Scenario: Check Mandatory field
    Given I am open patient page
    When I click add patient
    And I click save patient
    Then Error Mandatory field is show
    
		
		
		