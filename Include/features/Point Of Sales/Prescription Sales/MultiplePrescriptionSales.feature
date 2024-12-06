#Author: your.email@your.domain.com
@PrescriptionSales
Feature: Prescription Sales
  
  Background: User is Logged In and open Front Office page
	Given I already login as FO
	And I already open FO page
	
@MultiplePrescription
  Scenario: Add new Multiple Prescription
    Given I am open prescription sales page
    And I search pharmacy registration data
    When I open prescription sales detail
    And I verify pharmacy registration data
    And I select prescription data - multiple
    And I click next
    And I add prescription special detail
    And I select other prescription
    And I add prescription detail
    And I verify prescription sales data
    And I click next
    And I add additional product
    And I re-verify prescription sales data 
    And I click next
    And I input prescription payment info
    Then Prescription Sales data successfully submitted
    
@AddManualPrescription
	Scenario: Add Manual Prescription
    Given I am open prescription sales page
    And I search pharmacy registration data
    When I open prescription sales detail
    And I verify pharmacy registration data
    And I click add copy prescription
    And I click yes
    And I input copy prescription form
    And I select prescription data - manual
    And I click next
    And I add prescription manual detail
    And I verify prescription sales data
    And I click next
    And I add additional product
    And I re-verify prescription sales data 
    And I click next
    And I input prescription payment info
    Then Prescription Sales data successfully submitted