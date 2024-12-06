#Author: your.email@your.domain.com

@AddPatient
Feature: Patient Feature

  Background: User is Logged In and open patient page
	Given I already login as FO
	When I already open FO page

  @AddAddress
  Scenario: Edit Patient - Add new patient addres from address form
    Given I am open patient page
		And I search patient data
		And I open patient detail page
    When I click add address
    And I input all address field
    And I click save address
    Then Address succesfully added
    
  @EditPatientAddress
		Scenario: Edit Patient - Edit patient address
		Given I am open patient page
		And I search patient data
		And I open patient detail page
		And I select address
		And I edit address data
		And I click save address
    Then Address succesfully updated