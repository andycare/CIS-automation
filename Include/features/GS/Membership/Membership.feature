#Author: your.email@your.domain.com

@Membership
Feature: Membership Feature
I want to use this template for my feature file

  Background: User is Logged In and open Membership Page
	Given I already login
	When I already open general setup page

  @Membership1
  Scenario: Add New Membership with individu category
    Given I open membership page
    When I click add membership button
    And I input data information field with individu category
    And I click save button
    Then Membership successfully added
    
   @Membership2
   Scenario: Add New Membership with Company Category
    Given I open membership page
    When I click add membership button
    And I input data information field with company category
    And I click save button
    Then Membership successfully added
    
   @Membership3
	  Scenario: Edit Membership - Add Membership Branch 
		 Given I open membership page
		 And I search membership data
		 And I click edit membership 
		 When I click add branch
		 And I input all branch field
		 And I click save branch
		 Then Branch membership succesfully added
		
	  @Membership4
		Scenario: Edit Membership - Add Membership Product Service without Is Apply To All
		 Given I open membership page
		 And I search membership data
		 And I click edit membership 
		 When I click add product service
		 And I input product service field without is apply to all
		 And I click save product service
		 Then Product service without is apply to all succesfully added

	  @Membership5
		Scenario: Edit Membership - Add Membership Product Service with Is Apply To All
		 Given I open membership page
		 And I search membership data
		 And I click edit membership 
		 When I click add product service
		 And I input product service field with is apply to all
		 And I click save product service
		 Then Product service with is apply to all succesfully added
		
		@Membership6
		Scenario: Search Membership
  	 Given I open membership page
  	 When I search membership data
		 Then Successfully display membership data	
		
		@Membership7
		Scenario: Edit Membership - Delete Branch
		 Given I open membership page
		 And I search membership data
		 And I click edit membership
		 When I click delete branch
		 Then I successfully delete membership branch
		 
		@Membership8
		Scenario: Edit Membership - Delete Product Service
		 Given I open membership page
		 And I search membership data
		 And I click edit membership
		 When I click delete product service
		 Then I successfully delete membership product service
		 
	  @Membership9
		Scenario: Edit Membership Type
		 Given I open membership page
		 And I search membership data
		 And I click edit membership
		 When I edit membership
		 And I click save button
		 Then I successfully edit membership
		
		@Membership10
		Scenario: Edit Membership - Edit Membership Branch
		 Given I open membership page
		 And I search membership data
		 And I click edit membership
		 When I click select branch
		 And I edit branch
		 And I click save editing branch
		 Then I successfully edit branch
		  
		@Membership11
		Scenario: Edit Membership - Edit Membership Product Service
		 Given I open membership page
		 And I search membership data
		 And I click edit membership
		 When I click select product service
		 And I edit product service
		 And I click save editing product service
		 Then I successfully edit product service
		 
		@Membership12		
		Scenario: Delete Membership
		 Given I open membership page
		 And I search membership to delete
		 When I click delete button
		 And I click yes button 
		 Then Successfully delete membership data	
		 
		@Membership13
		Scenario: Bulk Delete Membership
		 Given I open membership page
		 And I search membership to delete
		 When I select membership data
		 And I click bulk delete membership
		 Then Successfully bulk delete membership data	
		 
		@Membership14
		Scenario: Edit Membership - Search Branch Data
		 Given I open membership page
		 And I search membership data
		 And I click edit membership
		 When I search membership branch
		 Then Successfully display membership branch
		 
		 
		 @Membership15
		 Scenario: Edit Membership - Search Product Service Data
		 Given I open membership page
		 And I search membership data
		 And I click edit membership
		 When I search membership product service
		 Then Successfully display membership product service 
		 
		 
		 @Membership16
		 Scenario: Edit Membership - Inactive Membership Status
		  Given I open membership page
			And I click edit membership
			When I inactive membership status
			And I click save button
			Then Membership status is inactive
		 
		 @Membership17
		 Scenario: Edit Membership - Search Invalid Branch Data
		  Given I open membership page
		  And I search membership data
		  And I click edit membership
		  When I search invalid branch data
		  Then Successfully display no results found
		  
		 @Membership18
		 Scenario: Edit Membership - Search Invalid Product Service Data
		 Given I open membership page
		 And I search membership data
		 And I click edit membership
		 When I search invalid product service data
		 Then Successfully display no results found
		
		