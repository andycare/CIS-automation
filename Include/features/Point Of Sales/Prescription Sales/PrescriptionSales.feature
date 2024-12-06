#Author: your.email@your.domain.com
@PrescriptionSales
Feature: Prescription Sales
  
  Background: User is Logged In and open Front Office page
	Given I already login as FO
	And I already open FO page

  @PrescriptionStandard
  Scenario: Add new Prescription Standard
    Given I am open prescription sales page
    And I search pharmacy registration data
    When I open prescription sales detail
    And I verify pharmacy registration data
    And I select prescription data - standard
    And I click next
    And I add prescription detail
    And I verify prescription sales data
    And I click next
    And I add additional product
    And I re-verify prescription sales data 
    And I click next
    And I input prescription payment info
    Then Prescription Sales data successfully submitted
    
  @PrescriptionSpecial
  Scenario: Add new Prescription Special
    Given I am open prescription sales page
    And I search pharmacy registration data
    When I open prescription sales detail
    And I verify pharmacy registration data
    And I select prescription data - special
    And I click next
    And I add prescription special detail
    And I verify prescription sales data
    And I click next
    And I add additional product
    And I re-verify prescription sales data 
    And I click next
    And I input prescription payment info
    Then Prescription Sales data successfully submitted