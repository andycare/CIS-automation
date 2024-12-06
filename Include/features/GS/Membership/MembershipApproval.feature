#Author: your.email@your.domain.com

@MembershipApproval
Feature: Patient Feature

  Background: User is Logged In and open membership page
	Given I already login as Admin
	When I already open general setup page

  	@MembershipApproval
		Scenario: Approve membership request
		Given I open membership page
		And I search membership data
		And I click edit membership
		When I already open membership detail
		And I approve membership request
		Then Membership approval success