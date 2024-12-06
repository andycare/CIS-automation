#Author: your.email@your.domain.com

@DirectSalesNewPatient
Feature: Direct Sales New Patient
  I want to use this template for my feature file
  
  Background: User is Logged In and open Front Office page
	Given I already login as FO
	And I already open FO page
    
    @directsales5
  Scenario: New patient - new membership - no delivery
    Given I am open direct sales page
    And I input direct sales patient data
    When I open new direct sales detail page
    And I input sales info data1
    And I click add product
    And I add Product Service
    And I add Inventory List
    And I save product
    And I validate product data
    And I click next
    And I input payment info
    Then Direct Sales data successfully created
    And Validate payment data is correct
    
    @directsales6
    Scenario: New patient - New Membership - use delivery
    Given I am open direct sales page
    And I input direct sales patient data
    When I open new direct sales detail page
    And I input sales info data1
    And I input new delivery info
    And I click add product
    And I add Product Service
    And I add Inventory List
    And I save product
    And I validate product and delivery data
    And I click next
    And I input payment info
    Then Direct Sales data successfully created
    And Validate payment & delivery data is correct
    
    
    
    