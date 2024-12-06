#Author: your.email@your.domain.com

@PatientMembership
Feature: Patient Feature

  Background: User is Logged In and open patient page
	Given I already login as FO
	When I already open FO page

  	@AddMembership
		Scenario: Edit Patient - Add new patient Membership from Membership form
		Given I am open patient page
		And I search patient data
		And I open patient detail page
		When I click tab membership
		And I click add membership
		And i input all membership field
		And I click save membership
		Then membership succesfully added
		And status is Waiting Add Approval
		And I approve request
    
    @DeleteMembership
		Scenario: Edit Patient - Delete patient Membership
		Given I am open patient page
		And I search patient data
		And I open patient detail page
		When I click tab membership
		And I click delete membership
		And I click yes
		Then Membership succesfully updated
		And status is Waiting Delete Approval
		And I approve request